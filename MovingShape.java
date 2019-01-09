/*
 *	===============================================================================
 *	MovingShape.java : 
 *	The main controller of each individual shape and their moving path.
 *	===============================================================================
 */
import java.awt.*;

public abstract class MovingShape {
    public int marginWidth, marginHeight; // the margin of the animation panel area
    protected int x, y;             // the top left coner of shapes
    protected int width, height;            // the width and height of shapes
    protected MovingPath path;            // the moving path of shapes
    protected Color borderColor, fillColor;        // the border colour of shapes
    protected boolean selected = false;    // draw handles if selected


	/** constuctor to create a rectangle with default values
	 */
	public MovingShape() {
		this(10, 20, 50, 20, 500, 500, Color.orange, Color.yellow, Path.FALLING); // the default properties
	}

	/** constuctor to create a rectangle shape
	 */
	public MovingShape(int x, int y, int w, int h, int mw, int mh, Color bc, Color fc, Path pathType) {
		this.x = x;
		this.y = y;
		width = w;
		height = h;
		marginWidth = mw;
		marginHeight = mh;
		borderColor = bc;
		fillColor = fc;
        setPath(pathType);
	}

    /** Return the x-coordinate of the shape.
     * @return the x coordinate
     */
    public int getX() { return x; }
    /** Return the y-coordinate of the shape.
     * @return the y coordinate
     */
    public int getY() { return y;}
    /** Set the X value of the shape.
     * @param x     the x value
     */
    public void setX(int x) { this.x = x; }
    /** Set the Y value of the shape.
     * @param y     the y value
     */
	public void setY(int y) { this.y = y; }
    /** Set the width of the shape.
     * @param w     the width value
     */
    public void setWidth(int w) { width = w; }
    /** Set the height of the shape.
     * @param h     the height value
     */
    public void setHeight(int h) { height = h; }
    /** Return the selected property of the shape.
     * @return the selected property
     */
    public boolean isSelected() { return selected; }
    /** Set the selected property of the shape.
     *    When the shape is selected, its handles are shown.
     * @param s     the selected value
     */
    public void setSelected(boolean s) { selected = s; }
    /** Set the border colour of the shape.
     * @param c     the border colour
     */
    public void setBorderColor(Color c) { borderColor = c; }
    /** Set the border colour of the shape.
     * @param c     the border colour
     */
    public void setFillColor(Color fc) { fillColor = fc; }
    /**
     * Return a string representation of the shape, containing
     * the String representation of each element.
     */
    public String toString() {
        return "[" + this.getClass().getName() + "," + x + "," + y + "]";
    }

    /** Reset the margin for the shape
     * @param w     the margin width
     * @param h     the margin height
     */
    public void setMarginSize(int w, int h) {
        marginWidth = w;
        marginHeight = h;
    }

    /** Draw the handles of the shape
     * @param g     the Graphics control
     */
    public void drawHandles(Graphics g) {
        // if the shape is selected, then draw the handles
        if (isSelected()) {
            g.setColor(Color.black);
            g.fillRect(x -2, y-2, 4, 4);
            g.fillRect(x + width -2, y + height -2, 4, 4);
            g.fillRect(x -2, y + height -2, 4, 4);
            g.fillRect(x + width -2, y-2, 4, 4);
        }
    }

	/** draw the rectangle with the fill colour
	 *	If it is selected, draw the handles
	 *	@param g	the Graphics control
	 */
	public abstract void draw(Graphics g);

	/** Returns whether the point is in the rectangle or not
	 * @return true if and only if the point is in the rectangle, false otherwise.
	 */
	public abstract boolean contains(Point mousePt);

    /** Set the path of the shape.
     * @param pathID     the integer value of the path
     *    MovingPath.FALLING is the falling path
     */
    public void setPath(Path pathID) {
        switch (pathID) {
            case BOUNCING : {
                path = new BouncingPath(5,10);
                break;
            }
            case FALLING : {
                path = new FallingPath(0,10);
                break;
            }
        }
    }

    /** move the shape by the path
     */
    public void move() {
        path.move();
    }

    // Inner class ===================================================================== Inner class
    /*
     *    ===============================================================================
     *    MovingPath : The superclass of all paths. It is an inner class.
     *    A path can change the current position of the shape.
     *    ===============================================================================
     */

    public abstract class MovingPath {
        protected int deltaX, deltaY; // moving distance

        /** constructor
         */
        public MovingPath() { }

        /** abstract move method
        * move the shape according to the path
        */
        public abstract void move();
    }

    /*
     *  ===============================================================================
     *  BouncingPath : A Bouncing path.
     *  ===============================================================================
     */
    public class BouncingPath extends MovingPath {

         /** constructor to initialise values for a bouncing path
         */
        public BouncingPath(int dx, int dy) {
            deltaX = dx;
            deltaY = dy;
         }

        /** move the shape
         */
        public void move() {
             x = x + deltaX;
             y = y + deltaY;

             if ((x < 0) && (deltaX < 0)) {
                 deltaX = -deltaX;
                 x = 0;
             }
             else if ((x + width > marginWidth) && (deltaX > 0)) {
                 deltaX = -deltaX;
                 x = marginWidth - width;
             }
             if ((y< 0) && (deltaY < 0)) {
                 deltaY = -deltaY;
                 y = 0;
             }
             else if((y + height > marginHeight) && (deltaY > 0)) {
                 deltaY = -deltaY;
                 y = marginHeight - height;
             }
        }

    }
    /*
     *  ===============================================================================
     *  FallingPath : A Falling path.
     *  ===============================================================================
     */

    public class FallingPath extends MovingPath {
        public FallingPath(int dx, int dy){
            deltaX = dx;
            deltaY = dy;
        }

        public void move(){
            x = x + deltaX;
            y = y + deltaY;

            if ((x < 0) && (deltaX < 0)) {
                deltaX = -deltaX;
                x = 0;
            }
            else if ((x + width > marginWidth) && (deltaX > 0)) {
                deltaX = -deltaX;
                x = marginWidth - width;
            }

            if((y > marginHeight)) {
                y = 0 - height;
            }
        }
    }
}


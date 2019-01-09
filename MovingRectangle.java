/*
 *	===============================================================================
 *	MovingRectangle.java : A shape that is a rectangle.
 *	A rectangle has 4 handles shown when it is selected (by clicking on it).
 *	===============================================================================
 */

import java.awt.*;

public class MovingRectangle extends MovingShape {
    public MovingRectangle(){
        super();
    }
    public MovingRectangle(int x, int y, int w, int h, int mw, int mh, Color bc, Color fc, Path pathType) {
        super(x, y, w, h, mw, mh, bc, fc, pathType);
    }

    @Override
    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setPaint(fillColor);
        g2d.fillRect(x, y, width, height);
        g2d.setPaint(borderColor);
        g2d.drawRect(x, y, width, height);
        drawHandles(g);
    }
    @Override
    public boolean contains(Point mousePt) {
        return (x <= mousePt.x && mousePt.x <= (x + width + 1) && y <= mousePt.y && mousePt.y <= (y + height + 1));
    }
}
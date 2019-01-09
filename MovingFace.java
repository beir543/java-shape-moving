/*
 *	===============================================================================
 *	MovingFace.java : A shape that is a face.
 *	A face has 4 handles shown when it is selected (by clicking on it).
 *	===============================================================================
 */

import java.awt.*;

public class MovingFace extends MovingOval {
    public MovingFace(){
        super();
    }
    public MovingFace(int x, int y, int w, int h, int mw, int mh, Color bc, Color fc, Path pathType) {
        super(x, y, w, h, mw, mh, bc, fc, pathType);
    }

    public void draw(Graphics g) {
        super.draw(g);
        int widthFraction = width/5;

        Graphics2D g2d = (Graphics2D) g;


        g2d.setPaint(Color.BLACK);
        g2d.fillOval(x+(int)1.5*widthFraction, y+(height/4), width/5, height/5);
        g2d.drawOval(x+(int)1.5*widthFraction, y+(height/4), width/5, height/5);

        g2d.fillOval(x+(int)2*widthFraction+(int)(width*.2), y+(height/4), width/5, height/5);
        g2d.drawOval(x+(int)2*widthFraction+(int)(width*.2), y+(height/4), width/5, height/5);


        g2d.drawArc(x+(int)1.5*width/4, y+height/3, width/2, height/2, 180, 180);

        drawHandles(g);
    }

}
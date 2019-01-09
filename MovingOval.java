/*
 *	===============================================================================
 *	MovingOval.java : A shape that is a oval.
 *	A oval has 4 handles shown when it is selected (by clicking on it).
 *	===============================================================================
 */

import java.awt.*;

public class MovingOval extends MovingShape {
    public MovingOval(){
        super();
    }
    public MovingOval(int x, int y, int w, int h, int mw, int mh, Color bc, Color fc, Path pathType) {
        super(x, y, w, h, mw, mh, bc, fc, pathType);
    }

    @Override
    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setPaint(fillColor);
        g2d.fillOval(x, y, width, height);
        g2d.setPaint(borderColor);
        g2d.drawOval(x, y, width, height);
        drawHandles(g);
    }
    @Override
    public boolean contains(Point mousePt) {
        double dx, dy;
        Point EndPt = new Point(x + width, y + height);
        dx = (2 * mousePt.x - x - EndPt.x) / (double) width;
        dy = (2 * mousePt.y - y - EndPt.y) / (double) height;
        return dx * dx + dy * dy < 1.0;
    }
}
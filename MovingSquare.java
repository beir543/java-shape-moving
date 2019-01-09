/*
 *	===============================================================================
 *	MovingSquare.java : A shape that is a square.
 *	A rectangle has 4 handles shown when it is selected (by clicking on it).
 *	The square always has the same width and height.
 *	===============================================================================
 */

import java.awt.*;

public class MovingSquare extends MovingRectangle {
    public MovingSquare(){
        super();
    }
    public MovingSquare(int x, int y, int w, int h, int mw, int mh, Color bc, Color fc, Path pathType) {
        super(x, y, Math.min(w, h), Math.min(w, h), mw, mh, bc, fc, pathType);
    }

    @Override
    public void setWidth(int w) {
        super.setWidth(w);
        super.setHeight(w);
    }

    @Override
    public void setHeight(int h) {
        super.setHeight(h);
        super.setWidth(h);
    }
}
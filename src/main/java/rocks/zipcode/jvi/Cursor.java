package rocks.zipcode.jvi;

public class Cursor {
    private Point _point;
    public Cursor() {
        this(0,0);
    }
    public Cursor(int r, int c) {
        this._point = new Point(0,0);
    }
    public Point getXY() {return _point; }
    public void setCursor(int x, int y) {
        this._point.set(x,y);
    }
}

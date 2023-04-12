package rocks.zipcode.jvi;

public class Point {
    int _x;
    int _y;

    Point(int x, int y) {
        this._x = x;
        this._y = y;
    }
    public int x() {return _x;}
    public int y() {return _y;}

    public void set(int x, int y) {
        this._x = x;
        this._y = y;
    }
}

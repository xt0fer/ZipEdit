package rocks.zipcode.jvi;

public class Cursor {
    private Point point;

    public Cursor() {
        this(0, 0);
    }

    public Cursor(int r, int c) {
        this.point = new Point(0, 0);
    }

    public Point getRC() {
        return new Point(point.r(), point.c());
    }

    public void setCursor(int r, int c) {
        this.point.set(r, c);
    }

}

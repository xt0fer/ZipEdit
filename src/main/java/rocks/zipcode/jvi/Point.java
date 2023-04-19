package rocks.zipcode.jvi;

public class Point {
    int c;
    int r;

    Point(int r, int c) {
        this.c = c;
        this.r = r;
    }

    public int c() {
        return c;
    }

    public int r() {
        return r;
    }

    public void set(int r, int c) {
        this.c = c;
        this.r = r;
    }
}

package rocks.zipcode.jvi;

public class Window {
    private int _rows = 0;
    private int _cols = 0;
    private Terminal _term;
    private Cursor _cursor;
    // private Buffer _buffer;
    // private View _view;

    public Window(int rows, int cols) {
        _rows = rows;
        _cols = cols;
        _term = new Terminal();
        Terminal.setRawMode();
        _term.cursorZero();
        _term.blankScreen();
        _cursor = new Cursor(0, 0);
    }

    public Window() {
        this(24, 80);
    }

    public void setCursor(int r, int c) {
        _term.setCursor(r, c);
    }

    public void drawStringAt(String s, int r, int c) {
        _term.setCursor(r, c);
        _term.putString(s);
    }

    public void clearToEOL(int r, int c) {
        _term.setCursor(r, c);
        _term.clearToEOL();
    }

    public void clear() {
        _term.blankScreen();
    }

    public Point getCursor() {
        return _cursor.getXY();
    }

    public int readKey() {
        return _term.readKey();
    }

    // public void setBuffer(Buffer b) {
    // _buffer = b;
    // }

    // public void setView(View v) {
    // _view = v;
    // }

    // public void draw() {

    // }

}

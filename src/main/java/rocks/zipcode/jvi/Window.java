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
        _term.setRawMode();
        _cursor = new Cursor(0, 0);
    }
    public Window() {this(24,80);}

    public void drawStringAt(String s, int r, int c) {
        _term.setCursor(r, c);
        _term.putString(s);
    }
    public void clearToEOL(int r, int c) {
        _term.setCursor(r, c);
        _term.clearToEOL();
    }

    public Point getCursor() {
        return _cursor.getXY();
    }

    public int readKey() {
        return _term.readKey();
    }

    public void done() {
        _term.setCookedMode();;
    }
    
    // public void setBuffer(Buffer b) {
    //     _buffer = b;
    // }
   
    // public void setView(View v) {
    //     _view = v;
    // }
   
    // public void draw() {

    // }

}

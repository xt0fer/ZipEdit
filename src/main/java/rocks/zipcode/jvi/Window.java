package rocks.zipcode.jvi;

public class Window {

    public Window(int rows, int cols) {
        this._rows = rows;
        this._cols = cols;
    }
    public Window() {this(24,80);}

    private int _rows = 0;
    private int _cols = 0;
    private Terminal _term;
    private Buffer _buffer;
    private View _view;

}

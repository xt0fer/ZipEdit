package rocks.zipcode.jvi;

public class Window {
    private int _rows = 0;
    private int _cols = 0;
    private Terminal _term;
    private Buffer _buffer;
    private View _view;

 
    public Window(int rows, int cols) {
        this._rows = rows;
        this._cols = cols;
        this._term = new Terminal();
    }
    public Window() {this(24,80);}

   
    public void draw(Buffer buffer) {

    }

}

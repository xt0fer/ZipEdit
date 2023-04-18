package rocks.zipcode.jvi;

public class View {
    private int _height;
    private int _width;
    private int _x;
    private int _y;

    private String _content;
    private Window _window;
    private Buffer _buffer;
    private Cursor _cursor;

    public View(int height, int width, int startX, int startY) {
        _x = startX;
        _y = startY;
        _cursor = new Cursor(startX, startY);
        _window = new Window(height, width);
        _height = height;
        _width = width;

        _buffer = new Buffer(0);
        _buffer.setContent("");
    }

    private View() {
        this(24, 80, 0, 0);
    }

    public void printBufferContent() {

        // this._window.draw(this._buffer);
    }

    // public void setHighlighter(Highlighter highlighter) {}

    public void resetCursor() {
    }
    public void insertAtCursor(Character ch) {
        _buffer.insertChar(ch);
    }
    
    public void setBuffer(String text) {
        _buffer.setContent(text);
    }

    public int getHeight() {
        return _height;
    }

    public void setBackgroundColor(int pair) {
    }

    private void setCursor(int r, int c) {

    }

    private void clearView() {
        _window.clear();
    }

    public Window get_window() {
        return _window;
    }

    public void draw() {
        _window.setCursor(_x, _y);
        for (int r = 1; r <= _height; r++) {
            String line = _buffer.getLine(r-1);
            _window.clearToEOL(_y + r, 0);
            _window.drawStringAt(line, _y + r, 0);
        }
    }

    public void readFile(String filename) {
        _buffer.readFile(filename);
    }

    /**
     * Highlighter stuff (not implemented)
     */
    // void enableHighlightingAt(int xStart, int xFinish, int y);
    // void disableHighlighting();
    // std::unique_ptr<Highlighter> _highlighter;
    // std::pair<std::pair<int, int>, int> _highlight;

}

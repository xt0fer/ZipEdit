package rocks.zipcode.jvi;

public class View {
    public View(int height, int width, int startX, int startY) {
        this._cursor = new Cursor(startX, startY);
        this._window = new Window(height, width);
        this._buffer = new Buffer(0);
        this._buffer.setContent("");
    }
    private View() {
        this(24, 80, 0,0);
    }

    public void printBufferContent() {
        
        this._window.draw(this._buffer);
    }

//    public void setHighlighter(Highlighter highlighter) {}

    public void resetCursor() {}

    public void printString(String text) {}

    public int getHeight() { return 0; }

    public void setBackgroundColor(int pair) {}

    private void setCursor(int x, int y) {}
    private void clearView() {}
    private int _height;
    private String _content;
    private Window _window;
    private Buffer _buffer;
    private Cursor _cursor;

/**
 * Highlighter stuff (not implemented)
 */
//        void enableHighlightingAt(int xStart, int xFinish, int y);
//       void disableHighlighting();
//        std::unique_ptr<Highlighter> _highlighter;
//        std::pair<std::pair<int, int>, int> _highlight;

}

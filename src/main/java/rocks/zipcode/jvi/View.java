package rocks.zipcode.jvi;

public class View {
    public View(int height, int width, int startX, int startY) {

    }
    private View() {}

    public void printBufferContent() {}

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


    // Highlighter stuff (not implemented)
//        void enableHighlightingAt(int xStart, int xFinish, int y);
//       void disableHighlighting();
//        std::unique_ptr<Highlighter> _highlighter;
//        std::pair<std::pair<int, int>, int> _highlight;

}

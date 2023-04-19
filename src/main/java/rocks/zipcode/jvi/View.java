package rocks.zipcode.jvi;

public class View {
    private int rows;
    private int cols;

    private int sr;
    private int sc; // window upper left start

    private Terminal term;
    private Buffer buffer;
    private Cursor cursor; // current edit point in this view

    public View(Terminal t, int maxrows, int maxcols, int startR, int startC) {
        term = t;
        sr = startR;
        sc = startC;
        cursor = new Cursor(startR, startC);
        term.setCursor(startR, startC);
        rows = maxrows;
        cols = maxcols;

        buffer = new Buffer(0);
        buffer.setContent("");
    }

    // public void setHighlighter(Highlighter highlighter) {}

    public void resetCursor() {
    }

    public void setCursor(int r, int c) {
        r = (r < 0) ? 0 : r;
        c = (c < 0) ? 0 : c;

        int tr = (r < rows) ? r : rows;
        int tc = (c < cols) ? c : cols;
        cursor.setCursor(tr, tc);
    }

    public void deltaCursor(int deltar, int deltac) {
        Point tp = cursor.getRC();
        setCursor(tp.r() + deltar, tp.c() + deltac);
    }

    public Point getCursor() {
        return cursor.getRC();
    }

    public void insertAtCursor(Character ch) {
        buffer.setPoint(cursor.getRC());
        buffer.insertChar(ch);
    }

    public void leftCursor() {
        deltaCursor(0, 1);
    }

    public void rightCursor() {
        deltaCursor(0, -1);
    }

    public void upCursor() {
        deltaCursor(-1, 0);
    }

    public void downCursor() {
        deltaCursor(1, 0);
    }

    public void setBuffer(String text) {
        buffer.setContent(text);
    }

    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }

    public void setBackgroundColor(int pair) {
    }

    public void draw() {
        for (int r = 0; r < rows; r++) {
            String line = buffer.getLine(r);
            term.clearToEOL(sr + r, 0);
            term.drawStringAt(line, sr + r, 0);
        }
        term.setCursor(cursor.getRC());
    }

    public void readFile(String filename) {
        buffer.readFile(filename);
    }

    /**
     * Highlighter stuff (not implemented)
     */
    // void enableHighlightingAt(int xStart, int xFinish, int y);
    // void disableHighlighting();
    // std::uniqueptr<Highlighter> highlighter;
    // std::pair<std::pair<int, int>, int> highlight;

}

package rocks.zipcode.jvi;

import java.util.ArrayList;

// Buffer is the main text containing Model.
public class Buffer {
    Point _point = new Point(0, 0);
    boolean _unsavedChanges;
    int _startLine;
    int _finishLine;
    boolean _insertModeEnabled;
    String _fileName;
    String _clipboard;
    int _clipboardLines;
    ArrayList<StringBuffer> _text;
    // FileHelper _fileHelper;


    public Buffer(int maxLines) {
        this._text = new ArrayList<>();
    }


    public String readFile(String fileName) { return ""; }
    public void replaceChar (char c, int x, int y){}
    public void insertChar (char c, int x, int y){
        if (_insertModeEnabled) {
            _point.set(x, y);
            StringBuffer line = _text.get(x);
            line.insert(y, c);
        }
    }
    public void insertString (String s, int x, int y){
        if (_insertModeEnabled) {
            _point.set(x, y);
            StringBuffer line = _text.get(x);
            line.insert(y, s);
        }
    }
    public void insertNewLine(int x, int y){
        // if y == 0, insert empty sb above x
        // if y == _text.x.size(), insert empty sb below x
        // if y >=0 && y< _text.x.size(), split line at y
    }
    public void deleteChar (int x, int y) {}
    public void deleteLine (int y) {}
    public void clear() {}
//
//    /*
//     * A bunch of omitted functions
//     */
//
    public int getNumLines() {return 0;}
//
    public String[] getLines(int lineStart, int lineFinish) {
        // NQR...
       if ((lineStart >= 0) && (lineFinish <= _text.size())) {
        String[] sarray = new String[lineFinish - lineStart];
        for (int idx = lineStart; idx <= lineFinish; idx++) {
            sarray[idx] = getLine(idx);
        }
        return sarray; 
       } else return null;
    }
    public String  getLine(int y) {return _text.get(y).toString(); }
    public String  getFileName() {return _fileName;}

    public    void saveFile() {}
    public boolean unsavedChanges() {return false;}

    public void setUnsavedChanges(boolean changes) {}
    //
    public void enableInsertMode() {
        _insertModeEnabled = true;
    }
    public void disableInsertMode() {
        _insertModeEnabled = false;
    }

//
//    std::pair<int, int> find(const std::string& s, bool fromCurrentLine = true);
//    std::pair<int, int> rfind(const std::string& s, bool fromCurrentLine = true);
//
/** 
 * Clipboard functions
 */
    public String clipboard() {return "";}
    public    void setClipboard(String str) {}
    public    int getClipboardLines() {return 0;}
    public    void setClipboardLines(int n) {}

    public void setContent(String s) {
        this.setBuffer(s);
    }
/**
 * private
 * 
 */
   
    private int populateBuffer() {return -1;}

    private void setBuffer(String s) {
        String[] sarray = s.split("\n");
        for (String s0 : sarray) append(s0);
    }

    private void append(String s) {
             _text.add(new StringBuffer(s));
    }
    private void insert(String s) {
        int _r = _point.x();
        StringBuffer line = _text.get(_r);
        line.insert(_point.y(), s);
    }
}

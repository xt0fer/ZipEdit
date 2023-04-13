package rocks.zipcode.jvi;

import java.util.ArrayList;
import java.util.Iterator;

// Buffer is the main text containing Model.
public class Buffer {
    Point _point = new Point(0, 0);
    boolean _unsavedChanges;
    Integer _startLine;
    Integer _finishLine;
    boolean _insertModeEnabled;
    String _fileName;
    String _clipboard;
    Integer _clipboardLines;
    ArrayList<StringBuffer> _text;
    // FileHelper _fileHelper;

    public Buffer(Integer maxLines) {
        this._text = new ArrayList<>();
    }

    public String readFile(String fileName) {
        return "";
    }

    public void replaceCharacter(Character c, Integer x, Integer y) {
    }

    public void insertCharacter(Character c, Integer x, Integer y) {
        if (_insertModeEnabled) {
            _point.set(x, y);
            StringBuffer line = _text.get(x);
            line.insert(y, Character.toString(c));
        }
    }

    public void insertString(String s, Integer x, Integer y) {
        if (_insertModeEnabled) {
            _point.set(x, y);
            StringBuffer line = _text.get(x);
            line.insert(y, s);
        }
    }

    public void insertNewLine(Integer x, Integer y) {
        // if y == 0, insert empty sb above x
        // if y == _text.x.size(), insert empty sb below x
        // if y >=0 && y< _text.x.size(), split line at y
    }

    public void deleteCharacter(Integer x, Integer y) {
    }

    public void deleteLine(Integer y) {
    }

    public void clear() {
    }

    //
    // /*
    // * A bunch of omitted functions
    // */
    //
    public Integer getNumLines() {
        return 0;
    }

    //
    public String[] getLines(Integer lineStart, Integer lineFinish) {
        // NQR...
        if ((lineStart >= 0) && (lineFinish <= _text.size())) {
            String[] sarray = new String[lineFinish - lineStart];
            for (Integer idx = lineStart; idx <= lineFinish; idx++) {
                sarray[idx] = getLine(idx);
            }
            return sarray;
        } else
            return null;
    }

    public String getLine(Integer y) {
        return _text.get(y).toString();
    }

    public String getFileName() {
        return _fileName;
    }

    public void saveFile() {
    }

    public boolean unsavedChanges() {
        return false;
    }

    public void setUnsavedChanges(boolean changes) {
    }

    //
    public void enableInsertMode() {
        _insertModeEnabled = true;
    }

    public void disableInsertMode() {
        _insertModeEnabled = false;
    }

    //
    // std::pair<Integer, Integer> find(const std::string& s, bool fromCurrentLine =
    // true);
    // std::pair<Integer, Integer> rfind(const std::string& s, bool fromCurrentLine
    // = true);
    //
    /**
     * Clipboard functions
     */
    public String clipboard() {
        return "";
    }

    public void setClipboard(String str) {
    }

    public Integer getClipboardLines() {
        return 0;
    }

    public void setClipboardLines(Integer n) {
    }

    public void setContent(String s) {
        this.setBuffer(s);
    }

    public String contents() {
        StringBuffer fsb = new StringBuffer();
        Iterator<StringBuffer> sbi = _text.iterator();
        while (sbi.hasNext()) {
            fsb.append(sbi.next());
        }
        return fsb.toString();
    }

    /**
     * private
     * 
     */

    private Integer populateBuffer() {
        return -1;
    }

    private void setBuffer(String s) {
        String[] sarray = s.split("\n");
        for (String s0 : sarray)
            append(s0);
    }

    private void append(String s) {
        _text.add(new StringBuffer(s));
    }

    private void insert(String s) {
        Integer _r = _point.x();
        StringBuffer line = _text.get(_r);
        line.insert(_point.y(), s);
    }
}

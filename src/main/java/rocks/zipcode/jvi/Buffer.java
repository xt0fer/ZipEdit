package rocks.zipcode.jvi;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
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
        _text = new ArrayList<>();
        _text.add(0, new StringBuffer(""));
    }

    public String readFile(String fileName) {
        BufferedReader reader;

        try {
            reader = new BufferedReader(new FileReader(fileName));
            String line = reader.readLine();

            while (line != null) {
                this.textappend(line);
                line = reader.readLine();
            }

            reader.close();
        } catch (IOException e) {
            return "Unable to read file";
        }
        return "File read";
    }

    public void replaceCharacter(Character c, Integer x, Integer y) {
        _point.set(x, y);
        StringBuffer line = _text.get(x);
        line.deleteCharAt(y);
        line.insert(y, Character.toString(c));
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
        _point.set(x, y);
        StringBuffer line = _text.get(x);
        line.deleteCharAt(y);
    }

    public void deleteLine(Integer y) {
        if (_hasLine(y))
            _text.remove(y.intValue());
    }

    private boolean _hasLine(Integer y) {
        if (y >= 0 && y < _text.size())
            return true;
        return false;
    }

    public void clear() {
        _text.clear();
        _text.add(0, new StringBuffer(""));
    }

    //
    // /*
    // * A bunch of omitted functions
    // */
    //
    public Integer getNumLines() {
        return _text.size();
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
        if (y < _text.size())
            return _text.get(y).toString();
        return "~";
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

    public boolean insertModeOn() {
        return _insertModeEnabled;
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

    @Override
    public String toString() {
        StringBuffer fsb = new StringBuffer();
        Iterator<StringBuffer> sbi = _text.iterator();
        while (sbi.hasNext()) {
            fsb.append(sbi.next());
            fsb.append("\n");
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
            this.textappend(s0);
    }

    private void textappend(String s) {
        if (_text.size() == 1 && _text.get(0).toString().equals("")) {
            _text.clear();
        }
        _text.add(new StringBuffer(s));
    }

    private void insert(String s) {
        Integer _r = _point.x();
        StringBuffer line = _text.get(_r);
        line.insert(_point.y(), s);
    }
}

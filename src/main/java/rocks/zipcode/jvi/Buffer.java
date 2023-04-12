package rocks.zipcode.jvi;

import java.util.ArrayList;

// Buffer is the main text containing Model.
public class Buffer {
    public Buffer(int maxLines) {}
    public String readFile(String fileName) { return ""; }
    public void replaceChar (char c, int x, int y){}
    public void insertChar (char c, int x, int y){}
    public void insertString (String str, int x, int y){}
    public void insertNewLine(int x, int y){}
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
    public String getLines(int lineStart, int lineFinish) { return ""; }
    public String  getLine(int y) {return "";}
    public String  getFileName() {return "";}
//
public    void saveFile() {}
public boolean unsavedChanges() {return false;}

public void setUnsavedChanges(boolean changes) {}
//
public void enableInsertMode() {}
public void disableInsertMode() {}

//
//    std::pair<int, int> find(const std::string& s, bool fromCurrentLine = true);
//    std::pair<int, int> rfind(const std::string& s, bool fromCurrentLine = true);
//
//    //Clipboard functions
    public String clipboard() {return "";}
    public    void setClipboard(String str) {}
    public    int getClipboardLines() {return 0;}
    public    void setClipboardLines(int n) {}
//
//    private
    private int populateBuffer() {return -1;}
//
    boolean _unsavedChanges;
    int _startLine;
    int _finishLine;
    boolean _insertModeEnabled;
    String _fileName;
    String _clipboard;
    int _clipboardLines;
    ArrayList<StringBuffer> _text;
    // FileHelper _fileHelper;

}

package rocks.zipcode.jvi;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

// Buffer is the main text containing Model.
public class Buffer {
    Point point = new Point(0, 0); // point of current edit
    Point mark = new Point(0, 0);
    boolean unsavedChanges;
    Integer startLine;
    Integer finishLine;
    boolean insertModeEnabled;
    String fileName;
    String clipboard;
    Integer clipboardLines;
    ArrayList<StringBuffer> text;
    // FileHelper fileHelper;

    public Buffer(Integer maxLines) {
        text = new ArrayList<>();
        text.add(0, new StringBuffer(""));
    }

    public void setPoint(Point tp) {
        point.set(tp.r(), tp.c());
    }

    public void replaceCharacter(Character ch, Integer r, Integer c) {
        point.set(r, c);
        StringBuffer line = text.get(r);
        line.deleteCharAt(c);
        line.insert(c, Character.toString(ch));
    }

    public void insertCharacter(Character ch, Integer r, Integer c) {
        if (insertModeEnabled) {
            point.set(r, c);
            StringBuffer line = text.get(r);
            line.insert(c, Character.toString(ch));
        }
    }

    public void insertString(String s, Integer r, Integer c) {
        if (insertModeEnabled) {
            point.set(r, c);
            StringBuffer line = text.get(r);
            line.insert(c, s);
        }
    }

    public void insertNewLine(Integer r, Integer c) {
        // if y == 0, insert empty sb above x
        // if y == text.x.size(), insert empty sb below x
        // if y >=0 && y< text.x.size(), split line at y
    }

    public void deleteCharacter(Integer r, Integer c) {
        point.set(r, c);
        StringBuffer line = text.get(r);
        line.deleteCharAt(c);
    }

    public void deleteLine(Integer r) {
        if (hasLine(r))
            text.remove(r.intValue());
    }

    private boolean hasLine(Integer r) {
        if (r >= 0 && r < text.size())
            return true;
        return false;
    }

    public void clear() {
        text.clear();
        text.add(0, new StringBuffer(""));
    }

    //
    // /*
    // * A bunch of omitted functions
    // */
    //
    public Integer getNumLines() {
        return text.size();
    }

    //
    public String[] getLines(Integer lineStart, Integer lineFinish) {
        // NQR...
        if ((lineStart >= 0) && (lineFinish < text.size())) {
            String[] strArray = new String[lineFinish - lineStart];
            for (Integer idx = lineStart; idx < lineFinish; idx++) {
                strArray[idx - 1] = getLine(idx);
            }
            return strArray;
        } else
            return null;
    }

    public String getLine(Integer r) {
        if (r < text.size())
            return text.get(r).toString();
        return "~";
    }

    public String getFileName() {
        return fileName;
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

    public void saveFile() {
    }

    public boolean unsavedChanges() {
        return false;
    }

    public void setUnsavedChanges(boolean changes) {
    }

    //
    public void enableInsertMode() {
        insertModeEnabled = true;
    }

    public void disableInsertMode() {
        insertModeEnabled = false;
    }

    public boolean insertModeOn() {
        return insertModeEnabled;
    }

    public void insertChar(Character ch) {
        insert(Character.toString(ch));
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
        Iterator<StringBuffer> sbi = text.iterator();
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
        if (text.size() == 1 && text.get(0).toString().equals("")) {
            text.clear();
        }
        text.add(new StringBuffer(s));
    }

    private void insert(String s) {
        StringBuffer line = text.get(point.r());
        line.insert(point.c(), s);
    }
}

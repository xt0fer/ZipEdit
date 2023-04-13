package rocks.zipcode.jvi;

import rocks.zipcode.jvi.util.Stack;

// Second (and ongoing) version.
public class Application {

    private Application() {}

    public Application(String filename) {
        this._fileName = filename;
        this._textView = new View(24, 80, 0, 0);
    }

    public static void main(String[] args) throws Exception {
        if (args.length < 2) {
            throw new Exception("No filename on command line");
        }
        Application app = new Application(args[1]);
    }
    public Mode getMode() { return null; }
    public void setMode(Mode newmode) {}
    public void updateViews() {}
    public void updateStatusView(String status) {}
    public int getChar() { return 0; }

//   public void addHighlighter(HighLighter highlighter);

    // private vars
    private Mode _mode;
    private View _textView;

    private Stack<Command> _commandStack;
    private View _statusView;
    private DebugView _debugView;
    String _highlighterUsed;
    String _fileName;

    //Arraylist<Highlighter> _highlighters;
    private boolean _debugModeEnabled;

}

package rocks.zipcode.jvi;

import rocks.zipcode.jvi.util.Stack;

// Second (and ongoing) version.
public class Application implements Runnable {
    // private vars
    private Mode _mode;
    private View _textView;
    private Controller _controller;

    private Stack<Command> _commandStack;
    private View _statusView;
    private DebugView _debugView;
    String _highlighterUsed;
    String _fileName;

    // Arraylist<Highlighter> _highlighters;
    private boolean _debugModeEnabled;

    public Application(String filename) {
        _mode = Mode.COMMAND;
        _fileName = filename;
        _textView = new View(23, 80, 0, 0);
        _statusView = new View(1, 80, 0, 23);
        _controller = new Controller(this, _textView);
        if (filename != "") {
            _textView.readFile(filename);
        }
    }

    public static void main(String[] args) throws Exception {
        // if (args.length < 1) {
        // throw new Exception("No filename on command line");
        // }
        Application app = new Application("test.txt");
        app.run();
        Terminal.setCookedMode();
        System.out.println("done.");
    }

    public Mode getMode() {
        return null;
    }

    public void setMode(Mode newmode) {
    }

    public void updateViews() {
        _textView.draw();
    }

    public void updateStatusView(String status) {
        _statusView.setBuffer(status);
        _statusView.draw();
    }

    public int getChar() {
        return 0;
    }

    // public void addHighlighter(HighLighter highlighter);

    @Override
    public void run() {
        _controller.listenForInputs();
    }

}

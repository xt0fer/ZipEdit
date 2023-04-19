package rocks.zipcode.jvi;

import rocks.zipcode.jvi.util.Stack;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

// Second (and ongoing) version.
public class Application implements Runnable {
    // private vars
    private Terminal terminal;
    private Point termSize;

    private Mode mode;
    private View textView;
    private Controller controller;

    private Stack<Command> commandStack;
    private View statusView;
    private DebugView debugView;
    String highlighterUsed;
    String fileName;

    // Arraylist<Highlighter> highlighters;
    private boolean debugModeEnabled;
    // logging
    Logger logger = Logger.getLogger("JVI");
    FileHandler fh;

    public Application(String filename) {
        mode = Mode.COMMAND;
        fileName = filename;
        terminal = new Terminal();
        try {
            termSize = terminal.getTerminalSize();
            // termSize is like 24x80...
            textView = new View(terminal, termSize.r()-1, termSize.c(), 0, 0);
            statusView = new View(terminal, 1, termSize.c(), termSize.r(), 0);
            controller = new Controller(this, textView, terminal);
            if (filename != "") {
                textView.readFile(filename);
            }
    
            } catch (IOException e) {
            e.printStackTrace();
            System.exit(-1);
        }
        // logging
        try {
            fh = new FileHandler("jvi.log");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        logger.addHandler(fh);
        SimpleFormatter formatter = new SimpleFormatter();
        fh.setFormatter(formatter);
        logger.setUseParentHandlers(false);

    }

    public Logger appLogger() {
        return logger;
    }

    public static void main(String[] args) throws Exception {
        // if (args.length < 1) {
        // throw new Exception("No filename on command line");
        // }
        Application app = new Application("test.txt");
        app.run();
        // on normal exit:
        Terminal.setCookedMode();
        System.out.println("done.");
    }

    public Mode getMode() {
        return mode;
    }

    public void setMode(Mode newmode) {
        mode = newmode;
    }

    public void updateViews() {
        textView.draw();
    }

    public void updateStatusView(String status) {
        statusView.setBuffer(status);
        statusView.draw();
    }

    // public void addHighlighter(HighLighter highlighter);

    @Override
    public void run() {
        logger.info("starting main event loop");
        controller.mainEventLoop();
    }

}

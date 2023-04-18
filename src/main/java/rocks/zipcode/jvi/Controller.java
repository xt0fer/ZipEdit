package rocks.zipcode.jvi;

public class Controller {
    private Application _app;
    private View _view;
    private Window _window;
    private String _lastSearchCommand;
    private String _lastFindChar;

    public Controller(Application app, View v) {
        _app = app;
        _view = v;
        _window = v.get_window();
    }

    public void listenForInputs() {
        Command what;
        String status = "ready (crtl-c to quit)";
        while (true) {
            _app.updateViews();
            _app.updateStatusView(status);
            _window.setCursor(0, 0);
            what = getCommand();

            if (what == Command.QUIT)
                break;
            if (what == Command.COLON) {
                // move cursor to status line.
                status = ":";
            }
            if (what == Command.ERR) {
                status = "error";
            }
            if (what == Command.INSERT) {
                listenInsertMode();
            }

        }
    }

    private Command getCommand() {
        int currentKey = _window.readKey();
        Character ch = (char) currentKey;
        Command what = Command.get(Character.toString(ch));

        if (what == Command.COLON) {
            _app.setMode(Mode.COMMAND);
            return what;
        }
        if (_app.getMode() == Mode.COMMAND) {
            if (what == Command.QUIT) {
                return what;
            }
        }
        return what;
    }

    private void listenInsertMode() {
        _app.setMode(Mode.INSERT);
        do {
            int currentKey = _window.readKey();
            Character ch = (char) currentKey;

            if (ch == 27)
                break;
            _view.insertAtCursor(ch);
            _app.updateViews();
        } while (true);
        _app.setMode(Mode.COMMAND);
    }

    private void listenCommandMode() {
    }

    private void listenReplaceMode() {
    }

    private void searchAndHighlight(String stringCommand,
            boolean highlight,
            boolean forward, boolean fromCurrentLine) {
    }

    private void performFindChar() {
    }

    //
    private void handleCursorMovement(int deltar, int deltac) {
    }

    private void handleClearAndDeleteCommands(boolean isClearCommand, int times) {
    }

    private void handleYank(int times) {
    }

    private int _repeatCommandNum = 0;

}

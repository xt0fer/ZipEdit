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

        while (true) {
            _app.updateViews();
            _app.updateStatusView("ready");
            what = getCommand();

            if (what == Command.QUIT) break;

        }
        _window.done();
    }
    private Command getCommand() {
        do {
            int currentKey = _window.readKey();
            Character ch = (char)currentKey;
            Command what = Command.get(Character.toString(ch));

            if (what == Command.COLON) {
                _app.setMode(Mode.COMMAND);
                continue;
            }
            if (_app.getMode() == Mode.COMMAND) {
                if (what == Command.QUIT) {
                    return what;
                }
            }
        } while (true);
    }



    private void listenInsertMode() {}
    private void listenCommandMode() {}
    private void listenReplaceMode() {}
    private void searchAndHighlight(String stringCommand,
                                    boolean highlight,
                                    boolean forward, boolean fromCurrentLine) {}
    private void performFindChar() {}

//
    private void handleCursorMovement(int deltar, int deltac) {}
    private void handleClearAndDeleteCommands(boolean isClearCommand, int times) {}
    private void handleYank(int times) {}
    private int _repeatCommandNum = 0;

}

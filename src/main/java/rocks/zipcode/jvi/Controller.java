package rocks.zipcode.jvi;

public class Controller {
 public Controller(Application app) {
     this._app = app;
 }

private Controller() {}

    public void listenForInputs() {}


    private void listenInsertMode() {}
    private void listenCommandMode() {}
    private void listenReplaceMode() {}
    private void searchAndHighlight(String stringCommand,
                                    boolean highlight,
                                    boolean forward, boolean fromCurrentLine) {}
    private void performFindChar() {}

    private Application _app;
    private boolean _quit;
    private String _lastSearchCommand;
    private String _lastFindChar;
//
    private void handleCursorMovement(int c) {}
    private void handleClearAndDeleteCommands(boolean isClearCommand, int times) {}
    private void handleYank(int times) {}
    int _repeatCommandNum = 0;

}

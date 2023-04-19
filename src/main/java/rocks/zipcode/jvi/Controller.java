package rocks.zipcode.jvi;

public class Controller {
    private Application app;
    private View view;
    private Terminal term;
    private String lastSearchCommand;
    private String lastFindChar;

    public Controller(Application a, View v, Terminal t) {
        app = a;
        view = v;
        term = t;
        Command.setController(this);
    }

    public void mainEventLoop() {
        Command what;
        view.draw();
        String status = "ready (crtl-c to quit)";
        while (true) {
            view.draw();
            what = getCommand();

            if (what == Command.QUIT)
                break;

            what.execute();
        }
    }

    private Command getCommand() {
        Character ch = (char) term.readKey();
        Command what = Command.get(Character.toString(ch));

        return what;
    }

    protected void listenInsertMode() {
        app.setMode(Mode.INSERT);
        do {
            Character ch = (char) term.readKey();

            if (ch == 27)
                break;
            view.insertAtCursor(ch);
            view.deltaCursor(0, 1);
            app.updateViews();
        } while (true);
        app.setMode(Mode.COMMAND);
    }

    protected void handleCursorMovement(int deltar, int deltac) {
        view.deltaCursor(deltar, deltac);
        Point p = view.getCursor();
        app.updateStatusView(String.format("handle cursor (%d,%d)", 
            p.r(), p.c()));
    }

    private void listenCommandMode() {
        app.setMode(Mode.COMMAND);

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
    private void handleClearAndDeleteCommands(boolean isClearCommand, int times) {
    }

    private void handleYank(int times) {
    }

    private int repeatCommandNum = 0;

}

package rocks.zipcode.jvi;

import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public enum Command {
    // ESC("\u001b"),
    COLON(":") {
        @Override
        boolean execute() {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'execute'");
        }

        @Override
        boolean undo() {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'undo'");
        }

        @Override
        boolean canUndo() {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'canUndo'");
        }
    },
    // NUM(";"),
    // NOP(""),
    ERR("E") {
        @Override
        boolean execute() {
            return false;
        }

        @Override
        boolean undo() {
            return false;
        }

        @Override
        boolean canUndo() {
            return false;
        }
    },
    QUIT("q") {
        @Override
        boolean execute() {
            return false;
        }

        @Override
        boolean undo() {
            return false;
        }

        @Override
        boolean canUndo() {
            return false;
        }
    },
    SAVE("w") {
        @Override
        boolean execute() {
            return false;
        }

        @Override
        boolean undo() {
            return false;
        }

        @Override
        boolean canUndo() {
            return false;
        }
    },

    INSERT("i") {
        @Override
        boolean execute() {
            crtlr.listenInsertMode();
            return true;
        }

        @Override
        boolean undo() {
            return false;
        }

        @Override
        boolean canUndo() {
            return false;
        }
    },

    UP("j") {
        @Override
        boolean execute() {
            crtlr.handleCursorMovement(-1, 0);
            return true;
        }

        @Override
        boolean undo() {
            return false;
        }

        @Override
        boolean canUndo() {
            return false;
        }
    },

    DOWN("k") {
        @Override
        boolean execute() {
            crtlr.handleCursorMovement(1, 0);
            return true;
        }

        @Override
        boolean undo() {
            return false;
        }

        @Override
        boolean canUndo() {
            return false;
        }
    },

    LEFT("l") {
        @Override
        boolean execute() {
            crtlr.handleCursorMovement(0, 1);
            return true;
        }

        @Override
        boolean undo() {
            return false;
        }

        @Override
        boolean canUndo() {
            return false;
        }
    },

    RIGHT("h") {
        @Override
        boolean execute() {
            crtlr.handleCursorMovement(0, -1);
            return true;
        }

        @Override
        boolean undo() {
            return false;
        }

        @Override
        boolean canUndo() {
            return false;
        }
    },

    // CLEAR("C"),
    // HELP("?"),
    // etc...
    ;

    abstract boolean execute();

    abstract boolean undo();

    abstract boolean canUndo();

    private String name;

    private static final Map<String, Command> ENUMMAP;

    private static Controller crtlr;

    Command(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    // Build an immutable map of String name to enum pairs.
    // Any Map impl can be used.

    static {
        Map<String, Command> map = new ConcurrentHashMap<String, Command>();
        for (Command instance : Command.values()) {
            map.put(instance.getName(), instance);
        }
        ENUMMAP = Collections.unmodifiableMap(map);
    }

    public static Command get(String name) {
        
        return ENUMMAP.getOrDefault(name, Command.ERR);
    }

    public static void setController(Controller controller) {
        crtlr = controller;
    }

}

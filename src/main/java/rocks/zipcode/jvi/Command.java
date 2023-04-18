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

    // CLEAR("C"),
    // HELP("?"),
    // etc...
    ;

    abstract boolean execute();
    abstract boolean undo();
    abstract boolean canUndo();

    private String name;

    private static final Map<String,Command> ENUM_MAP;

    Command (String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    // Build an immutable map of String name to enum pairs.
    // Any Map impl can be used.

    static {
        Map<String,Command> map = new ConcurrentHashMap<String, Command>();
        for (Command instance : Command.values()) {
            map.put(instance.getName(),instance);
        }
        ENUM_MAP = Collections.unmodifiableMap(map);
    }

    public static Command get (String name) {
        return ENUM_MAP.getOrDefault(name, Command.ERR);
    }

}

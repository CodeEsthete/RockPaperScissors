package org.nobel.rps;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import org.nobel.rps.core.Command;

public class Config {

    private static Config instance;

    private BiMap<Command, String> operations = HashBiMap.create();
    {
        operations.put(Command.HELP, "help");
        operations.put(Command.STATISTICS, "stat");
        operations.put(Command.CLEAN_STATISTICS, "clean");
        operations.put(Command.QUIT, "q");
        operations.put(Command.SCISSORS, "s");
        operations.put(Command.ROCK, "r");
        operations.put(Command.PAPER, "p");
    }

    public static Config getInstance() {
        if (instance == null) {
            instance = new Config();
        }
        return instance;
    }

    public String getKeyBinding(Command op) {
        return operations.get(op);
    }

    public BiMap<Command, String> getOperations() {
        return HashBiMap.create(operations);
    }

    public Command fromKey(String str) {
        Command command = operations.inverse().get(str);
        return command == null ? Command.UNKNOWN : command;
    }
}

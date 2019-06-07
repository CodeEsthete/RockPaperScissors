package org.nobel.rps.messages;

import org.nobel.rps.Config;
import org.nobel.rps.core.Command;

public class StartGameMessage extends AbstractMessage {

    public StartGameMessage(Config config) {
        super(config);
    }

    @Override
    public String getFormattedText() {
        StringBuilder info = new StringBuilder();
        appendLine(info, String.format("Hi! This is a Rock-Paper-Scissors game. Type '%s' to show controls.", config.getKeyBinding(Command.HELP)));
        return info.toString();
    }
}

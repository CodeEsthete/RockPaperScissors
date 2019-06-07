package org.nobel.rps.messages;

import org.nobel.rps.Config;
import org.nobel.rps.core.Command;

public class HelpMessage extends AbstractMessage {

    public HelpMessage(Config config) {
        super(config);
    }

    @Override
    public String getFormattedText() {
        // Apache commons CLI is a good library, but HelpFormatter prints on in std::out which is not what we want here
        // Hence doing similar manually
        StringBuilder builder = new StringBuilder();

        appendLine(builder, "Play commands:");
        appendLine(builder, formatCommand("scissors", Command.SCISSORS));
        appendLine(builder, formatCommand("rock", Command.ROCK));
        appendLine(builder, formatCommand("paper", Command.PAPER));
        appendLine(builder, "");
        appendLine(builder, "Other commands:");
        appendLine(builder, formatCommand("help", Command.HELP));
        appendLine(builder, formatCommand("statistics", Command.STATISTICS));
        appendLine(builder, formatCommand("clean statistics", Command.CLEAN_STATISTICS));
        appendLine(builder, formatCommand("quit", Command.QUIT));

        return builder.toString();
    }
}

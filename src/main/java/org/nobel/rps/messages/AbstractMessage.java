package org.nobel.rps.messages;

import org.nobel.rps.Config;
import org.nobel.rps.core.Command;

public abstract class AbstractMessage {

    private static final String COMMAND_FORMAT = "    %s - %s";
    private static final int COMMAND_KEY_LENGTH = 6;

    protected Config config;

    /**
     * Get formatted text that will be send as a response to the user.
     */
    public abstract String getFormattedText();

    /**
     * Constructor.
     */
    public AbstractMessage(Config config) {
        this.config = config;
    }

    protected void appendLine(StringBuilder info, String s) {
        info.append(s).append("\n");
    }

    protected String formatCommand(String name, Command command) {
        return String.format(COMMAND_FORMAT, ensureLength(config.getKeyBinding(command), COMMAND_KEY_LENGTH), name);
    }

    protected String ensureLength(String str, int expectedLength) {
        StringBuilder result = new StringBuilder(str);
        while (result.length() < expectedLength) {
            result.append(" ");
        }
        return result.toString();
    }
}

package org.nobel.rps.messages;

public class UnknownCommandMessage extends AbstractMessage {

    public UnknownCommandMessage() {
        super(null);
    }

    @Override
    public String getFormattedText() {
        StringBuilder text = new StringBuilder();
        appendLine(text, "Unknown command.");
        return text.toString();
    }
}

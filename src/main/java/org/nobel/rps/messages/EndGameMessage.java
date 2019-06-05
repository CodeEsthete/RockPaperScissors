package org.nobel.rps.messages;

public class EndGameMessage extends AbstractMessage {

    public EndGameMessage() {
        super(null);
    }

    @Override
    public String getFormattedText() {
        StringBuilder text = new StringBuilder();
        appendLine(text, "Bye! And have a great day.");
        return text.toString();
    }
}

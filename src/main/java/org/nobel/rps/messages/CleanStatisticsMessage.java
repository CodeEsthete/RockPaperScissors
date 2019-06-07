package org.nobel.rps.messages;

public class CleanStatisticsMessage extends AbstractMessage {

    public CleanStatisticsMessage() {
        super(null);
    }

    @Override
    public String getFormattedText() {
        StringBuilder builder = new StringBuilder();
        appendLine(builder, "Statistics removed.");
        return builder.toString();
    }
}

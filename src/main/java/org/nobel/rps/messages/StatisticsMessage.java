package org.nobel.rps.messages;

import org.nobel.rps.stat.GameStatistics;

public class StatisticsMessage extends AbstractMessage {

    private GameStatistics statistics;

    public StatisticsMessage(GameStatistics statistics) {
        super(null);
        this.statistics = statistics;
    }

    @Override
    public String getFormattedText() {
        StringBuilder builder = new StringBuilder();
        appendLine(builder, String.format("Wins: %s, Looses: %s, Draws : %s", statistics.getUserWins(), statistics.getAiWins(), statistics.getDraws()));
        return builder.toString();
    }
}

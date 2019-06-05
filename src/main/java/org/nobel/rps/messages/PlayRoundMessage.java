package org.nobel.rps.messages;

import org.nobel.rps.core.PlayResult;
import org.nobel.rps.stat.GameStatistics;

public class PlayRoundMessage extends AbstractMessage {

    private PlayResult playResult;
    private GameStatistics statistics;

    public PlayRoundMessage(PlayResult playResult, GameStatistics statistics) {
        super(null);
        this.playResult = playResult;
        this.statistics = statistics;
    }

    @Override
    public String getFormattedText() {
        StringBuilder builder = new StringBuilder();
        String playResultStr = null;
        switch (playResult) {
            case USER_WIN:
                playResultStr = "Win";
                break;
            case DRAW:
                playResultStr = "Draw";
                break;
            case AI_WIM:
                playResultStr = "Loose";
                break;
            default:
                throw new IllegalStateException("Unknown type here: " + playResult);

        }
        appendLine(builder, String.format("%s  Me - %s, You - %s", playResultStr, statistics.getAiWins(), statistics.getUserWins()));
        return builder.toString();
    }
}

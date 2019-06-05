package org.nobel.rps.core;

/**
 * Represents the result of single round.
 */
public enum PlayResult {

    USER_WIN,
    AI_WIM,
    DRAW;

    /**
     * Determine the result based on user and AI moves.
     */
    public static PlayResult determineResult(Move userMove, Move aiMove) {
        if ((aiMove.equals(Move.PAPER) && userMove.equals(Move.PAPER)) ||
                (aiMove.equals(Move.ROCK) && userMove.equals(Move.ROCK)) ||
                (aiMove.equals(Move.SCISSORS) && userMove.equals(Move.SCISSORS))) {
            return PlayResult.DRAW;
        } else if ((aiMove.equals(Move.PAPER) && userMove.equals(Move.ROCK)) ||
                (aiMove.equals(Move.ROCK) && userMove.equals(Move.SCISSORS)) ||
                (aiMove.equals(Move.SCISSORS) && userMove.equals(Move.PAPER))) {
            return PlayResult.AI_WIM;
        } else {
            return PlayResult.USER_WIN;
        }
    }
}

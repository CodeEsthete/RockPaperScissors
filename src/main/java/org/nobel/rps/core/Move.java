package org.nobel.rps.core;

/**
 * Play round moves.
 */
public enum Move {

    SCISSORS('s'),
    ROCK('r'),
    PAPER('p');

    private char value;

    Move(char value) {
        this.value = value;
    }

    public static Move fromOperation(Command command) {
        switch (command) {
            case SCISSORS:
                return Move.SCISSORS;
            case ROCK:
                return Move.ROCK;
            case PAPER:
                return Move.PAPER;
            default:
                throw new IllegalArgumentException("Unknown move type: " + command);
        }
    }

    public static Move fromValue(char c) {
        for (Move move : values()) {
            if (move.getValue() == c) {
                return move;
            }
        }
        return null;
    }

    public char getValue() {
        return value;
    }
}

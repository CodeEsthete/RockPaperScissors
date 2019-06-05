package org.nobel.rps.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MoveTest {

    @Test
    public void testFromOperation() {
        assertEquals(Move.ROCK, Move.fromOperation(Command.ROCK));
        assertEquals(Move.SCISSORS, Move.fromOperation(Command.SCISSORS));
        assertEquals(Move.PAPER, Move.fromOperation(Command.PAPER));
    }

    @Test
    public void testFromOperationThrowsException() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Move.fromOperation(Command.HELP);
        });
    }
}

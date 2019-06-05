package org.nobel.rps.algo;

import org.nobel.rps.core.Move;

import java.util.Random;

/**
 * This algorithm produce a random move on every play round based on java.util.Random.
 */
public class RandomAlgorithm implements RpsAlgorithm {

    private Random random = new Random();

    @Override
    public Move predictBeatMove() {
        return Move.values()[random.nextInt(Move.values().length)];
    }

    @Override
    public void addMove(Move previousMove) {
        // Nothing to do
    }
}

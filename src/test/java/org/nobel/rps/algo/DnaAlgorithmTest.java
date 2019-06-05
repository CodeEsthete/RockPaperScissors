package org.nobel.rps.algo;

import org.junit.jupiter.api.Test;
import org.nobel.rps.core.Move;
import org.nobel.rps.core.PlayResult;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class DnaAlgorithmTest {

    @Test
    public void testPatternWithRandom() {
        List<Move> patternedRandomMoves = getPatternedMoves(true);
        float expectedProbabilityThreshold = 0.33f;

        runAlgorithm(patternedRandomMoves, expectedProbabilityThreshold);
    }

    @Test
    public void testPurePattern() {
        List<Move> patternedRandomMoves = getPatternedMoves(false);
        float expectedLooseProbabilityThreshold = 0.02f;

        runAlgorithm(patternedRandomMoves, expectedLooseProbabilityThreshold);
    }

    @Test
    public void testPureRandom() {
        List<Move> patternedRandomMoves = getRandomMoves();
        float expectedLooseProbabilityThreshold = 0.35f; // Input is small, so statistically it can be more then 0.33333~

        runAlgorithm(patternedRandomMoves, expectedLooseProbabilityThreshold);
    }

    private void runAlgorithm(List<Move> moves, float expectedProbabilityThreshold) {
        RpsAlgorithm algorithm = new DnaAlgorithm();
        float total = 0;
        float looses = 0;
        for (Move userMove : moves) {
            Move aiMove = algorithm.predictBeatMove();
            algorithm.addMove(userMove);
            PlayResult playResult = PlayResult.determineResult(userMove, aiMove);
            if (playResult.equals(PlayResult.USER_WIN)) {
                looses++;
            }
            total++;
        }
        assertTrue(looses/total < expectedProbabilityThreshold);
    }

    private List<Move> getPatternedMoves(boolean mixWithRandom) {
        // Create patterned input
        List<Move> moves = new ArrayList<>();
        for (int i = 0 ; i < 100; i++) {
            moves.add(Move.PAPER);
            moves.add(Move.ROCK);
            moves.add(Move.SCISSORS);
            moves.add(Move.ROCK);
            moves.add(Move.SCISSORS);
        }

        if (mixWithRandom) {
            // Mix with random values to create random input
            int middleSize = moves.size() / 2;
            Random random = new Random();
            for (int i = 0 ; i < middleSize ; i++) {
                Move move = Move.values()[random.nextInt(Move.values().length)];
                moves.add(random.nextInt(moves.size()), move);
            }
        }
        return moves;
    }

    private List<Move> getRandomMoves() {
        List<Move> moves = new ArrayList<>();
        Random random = new Random();
        for (int i = 0 ; i < 1000; i++) {
            Move move = Move.values()[random.nextInt(Move.values().length)];
            moves.add(move);
        }
        return moves;
    }
}

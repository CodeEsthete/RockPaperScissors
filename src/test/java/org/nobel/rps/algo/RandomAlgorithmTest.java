package org.nobel.rps.algo;

import org.junit.jupiter.api.Test;
import org.nobel.rps.core.Move;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class RandomAlgorithmTest {

    @Test
    public void testMakeMove() {
        RpsAlgorithm algorithm = new RandomAlgorithm();
        Move move = algorithm.predictBeatMove();
        assertNotNull(move);
    }
}

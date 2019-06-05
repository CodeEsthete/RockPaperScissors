package org.nobel.rps.algo;

import org.nobel.rps.core.Move;

/**
 * RPS algorithm interface.
 */
public interface RpsAlgorithm {

    /**
     * Predict move should be invoked prior getting input from the user to make sure algorithm is fair.
     */
    Move predictBeatMove();

    /**
     * Add user's previous move to allow algorithm to predict values.
     */
    void addMove(Move previousMove);
}

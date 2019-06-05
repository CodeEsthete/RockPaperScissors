package org.nobel.rps.core;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

/**
 * Interface for Console Games.
 */
public interface IConsoleGame {

    /**
     * Method that starts a game. In and Out are streams for input/output correspondingly.
     */
    void start(BufferedReader in, PrintStream out) throws IOException;
}

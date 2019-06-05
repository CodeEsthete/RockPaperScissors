package org.nobel.rps.core;

import org.nobel.rps.algo.RpsAlgorithm;
import org.nobel.rps.messages.AbstractMessage;
import org.nobel.rps.Config;
import org.nobel.rps.messages.StartGameMessage;
import org.nobel.rps.stat.GameStatistics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

/**
 * RPS (Rock Paper Scissors) game implementation.
 */
public class RPSGame implements IConsoleGame {

    private RpsAlgorithm algorithm;

    /**
     * Constructor.
     */
    public RPSGame(RpsAlgorithm algorithm) {
        this.algorithm = algorithm;
    }

    @Override
    public void start(BufferedReader in, PrintStream out) throws IOException {
        // Init game with game started state
        Config config = Config.getInstance();
        AbstractMessage message = new StartGameMessage(config);
        out.println(message.getFormattedText());

        RPSController controller = new RPSController(config, algorithm, new GameStatistics());

        CommandResponse response = new CommandResponse("", GameState.CONTINUE);
        while (!response.getGameState().equals(GameState.QUIT)) {
            response = controller.readInputAndDispatch(in, config);
            out.print(response.getMessage());
        }
    }
}

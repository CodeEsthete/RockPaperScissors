package org.nobel.rps.core;

import org.nobel.rps.Config;
import org.nobel.rps.algo.RpsAlgorithm;
import org.nobel.rps.messages.AbstractMessage;
import org.nobel.rps.messages.CleanStatisticsMessage;
import org.nobel.rps.messages.EndGameMessage;
import org.nobel.rps.messages.HelpMessage;
import org.nobel.rps.messages.PlayRoundMessage;
import org.nobel.rps.messages.StatisticsMessage;
import org.nobel.rps.messages.UnknownCommandMessage;
import org.nobel.rps.stat.GameStatistics;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * Game controller. Commands can be refactored to separate components. Due to simplicity of the game it makes sense to keep them in one place.
 */
public class RPSController {

    private Config config;
    private RpsAlgorithm algorithm;
    private GameStatistics statistics;

    /**
     * Constructor.
     */
    public RPSController(Config config, RpsAlgorithm algorithm, GameStatistics statistics) {
        this.config = config;
        this.algorithm = algorithm;
        this.statistics = statistics;
    }

    /**
     * Read input from user and dispatch the request.
     */
    public CommandResponse readInputAndDispatch(BufferedReader in, Config config) throws IOException {
        String line = readLine(in);
        Command command = config.fromKey(line);

        AbstractMessage message;
        GameState state = command.equals(Command.QUIT) ? GameState.QUIT : GameState.CONTINUE;

        switch (command) {
            case PAPER:
            case SCISSORS:
            case ROCK:
                // Get AI move first
                Move aiMove = algorithm.predictBeatMove();
                Move usersMove = Move.fromOperation(command);

                PlayResult playResult = PlayResult.determineResult(usersMove, aiMove);
                // Save user's move so we can use this information in the next move
                algorithm.addMove(usersMove);
                message = new PlayRoundMessage(playResult, statistics);
                switch (playResult) {
                    case AI_WIM:
                        statistics.addAiWin();
                        break;
                    case DRAW:
                        statistics.addDraws();
                        break;
                    case USER_WIN:
                        statistics.addUserWin();
                        break;
                }
                break;
            case HELP:
                message = new HelpMessage(config);
                break;
            case STATISTICS:
                message = new StatisticsMessage(statistics);
                break;
            case CLEAN_STATISTICS:
                // Simply create new instance to support immutability
                statistics = new GameStatistics();
                message = new CleanStatisticsMessage();
                break;
            case QUIT:
                message = new EndGameMessage();
                break;
            case UNKNOWN:
                message = new UnknownCommandMessage();
                break;
            default:
                throw new NotImplementedException();
        }
        return new CommandResponse(message.getFormattedText(), state);
    }

    private String readLine(BufferedReader in) throws IOException {
        return in.readLine();
    }
}

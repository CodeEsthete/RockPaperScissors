package org.nobel.rps.core;

import org.junit.jupiter.api.Test;
import org.nobel.rps.Config;
import org.nobel.rps.algo.RandomAlgorithm;
import org.nobel.rps.messages.EndGameMessage;
import org.nobel.rps.messages.StartGameMessage;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * This simple test checks that the game can be played.
 * It start the game, sends 'Quit' command and read both output from the output.
 */
public class RPSGameTest {

    @Test
    public void testStartedGameCanQuit() throws IOException {
        Config config = Config.getInstance();
        InputStream inputStream = new ByteArrayInputStream(config.getKeyBinding(Command.QUIT).getBytes());
        System.setIn(inputStream);

        RPSGame game = new RPSGame(new RandomAlgorithm());

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(byteArrayOutputStream);

        try (BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in))) {
            game.start(inputReader, out);
        }
        String outputMessage = byteArrayOutputStream.toString();

        assertTrue(outputMessage.contains(new StartGameMessage(config).getFormattedText()));
        assertTrue(outputMessage.contains(new EndGameMessage().getFormattedText()));
    }
}

package org.nobel.rps;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.nobel.rps.algo.RpsAlgorithm;
import org.nobel.rps.algo.DnaAlgorithm;
import org.nobel.rps.algo.RandomAlgorithm;
import org.nobel.rps.core.IConsoleGame;
import org.nobel.rps.core.RPSGame;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Application {

    public static void main(String[] args) throws Exception {
        CommandLine commandLine = getCommandLine(args);

        RpsAlgorithm algorithm = initAlgorithm(commandLine);

        IConsoleGame game = new RPSGame(algorithm);
        try (BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in))) {
            game.start(inputReader, System.out);
        }
    }

    private static RpsAlgorithm initAlgorithm(CommandLine commandLine) {
        RpsAlgorithm algorithm = null;
        String algorithmType = commandLine.getOptionValue("algorithm", "ai");
        switch (algorithmType) {
            case "ai":
                System.out.println("Using AI algorithm.");
                algorithm = new DnaAlgorithm();
                break;
            case "random":
                System.out.println("Using Random algorithm.");
                algorithm = new RandomAlgorithm();
                break;
            default:
                System.out.println("Unknown algorithm");
                System.exit(0);
        }
        return algorithm;
    }

    private static CommandLine getCommandLine(String[] args) throws ParseException {
        CommandLineParser parser = new DefaultParser();
        Options options = new Options();
        options.addOption("a", "algorithm", true, "RpsAlgorithm.");
        return parser.parse(options, args);
    }
}

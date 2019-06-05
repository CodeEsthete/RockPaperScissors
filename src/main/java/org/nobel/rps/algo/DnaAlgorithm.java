package org.nobel.rps.algo;

import org.nobel.rps.core.Move;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * This algorithm is DNA based algorithm which tries to search patters in user pastMoves.
 * The longest pattern wins. It still uses java.util.Random when user pattern is not found.
 */
public class DnaAlgorithm implements RpsAlgorithm {

    private StringBuilder pastMoves;

    private Random random = new Random();

    // This is DNA encode for all possible pairs in single play round.
    private Map<String, String> dnaEncode = new HashMap<>();
    {
        dnaEncode.put("pp", "1");
        dnaEncode.put("pr", "2");
        dnaEncode.put("ps", "3");
        dnaEncode.put("rp", "4");
        dnaEncode.put("rs", "5");
        dnaEncode.put("rr", "6");
        dnaEncode.put("ss", "7");
        dnaEncode.put("sp", "8");
        dnaEncode.put("sr", "9");
    }

    // Beat moves e.g. r -> p  - Paper beats Rock etc.
    private Map<Character, Character> beatMoves = new HashMap<>();
    {
        beatMoves.put('r', 'p');
        beatMoves.put('p', 's');
        beatMoves.put('s', 'r');
    }

    private Move lastMove;

    private StringBuilder dna;

    public DnaAlgorithm() {
        this.pastMoves = new StringBuilder();
        this.dna = new StringBuilder();
    }

    @Override
    public Move predictBeatMove() {
        Move output = null;

        if (hasMoveToPredict()) {
            char lastHumanMove = pastMoves.charAt(pastMoves.length() - 1);
            char lastAIMove = lastMove.getValue();

            dna.append(dnaEncode.get("" + lastHumanMove + lastAIMove));

            String dnaStr = dna.toString();

            for (int checkLength = dnaStr.length() / 2 ; checkLength > 0 ; checkLength--) {
                if (dnaStr.length() < checkLength * 2) {
                    continue;
                }
                String lastN = dnaStr.substring(dnaStr.length() - checkLength);
                int x = dnaStr.substring(0, dnaStr.length() - checkLength).indexOf(lastN);
                if (x >= 0) {
                    Character nextMove = pastMoves.charAt(x + checkLength);
                    output = Move.fromValue(beatMoves.get(nextMove));
                    lastMove = output;
                    break;
                }
            }
        }

        lastMove = output == null ? Move.values()[random.nextInt(Move.values().length)] : output;
        return lastMove;
    }

    private boolean hasMoveToPredict() {
        return pastMoves.length() != 0;
    }

    @Override
    public void addMove(Move previousMove) {
        pastMoves.append(previousMove.getValue());
    }
}

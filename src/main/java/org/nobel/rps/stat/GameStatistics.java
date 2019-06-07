package org.nobel.rps.stat;

/**
 * In-memory only statistics. Going further it can be persisted to keep statistics between different starts.
 */
public class GameStatistics {

    /* User WINs */
    private int userWins;

    /* AI WINs */
    private int aiWins;

    /* Draws */
    private int draws;

    public void addUserWin() {
        userWins++;
    }

    public void addAiWin() {
        aiWins++;
    }

    public void addDraws() {
        draws++;
    }

    public int getUserWins() {
        return userWins;
    }

    public int getAiWins() {
        return aiWins;
    }

    public int getDraws() {
        return draws;
    }
}

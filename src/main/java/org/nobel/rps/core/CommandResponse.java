package org.nobel.rps.core;

/**
 * Command execution response.
 */
public class CommandResponse {

    private String message;
    private GameState gameState;

    public CommandResponse(String message, GameState gameState) {
        this.message = message;
        this.gameState = gameState;
    }

    public String getMessage() {
        return message;
    }

    public GameState getGameState() {
        return gameState;
    }
}

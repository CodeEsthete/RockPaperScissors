package org.nobel.rps.core;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CommandResponseTest {

    @Test
    public void testGetMessage(){
        CommandResponse commandResponse = new CommandResponse("Test", null);
        assertEquals("Test", commandResponse.getMessage());
    }

    @Test
    public void testGameState(){
        CommandResponse commandResponse = new CommandResponse(null, GameState.CONTINUE);
        assertEquals(GameState.CONTINUE, commandResponse.getGameState());
    }
}

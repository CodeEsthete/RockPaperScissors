package org.nobel.rps;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ConfigTest {

    @Test
    public void testOperations(){
        assertTrue(Config.getInstance().getOperations().size() > 0);
    }
}

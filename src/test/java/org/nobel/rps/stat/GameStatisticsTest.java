package org.nobel.rps.stat;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameStatisticsTest {

    @Test
    public void testAdds() {
        GameStatistics statistics = new GameStatistics();

        statistics.addUserWin();
        statistics.addUserWin();
        statistics.addUserWin();

        statistics.addDraws();
        statistics.addDraws();

        statistics.addAiWin();

        assertEquals(3, statistics.getUserWins());
        assertEquals(2, statistics.getDraws());
        assertEquals(1, statistics.getAiWins());
    }
}

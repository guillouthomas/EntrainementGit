package dcll.bowling2;

import dcll.ftsq.*;
import dcll.ftsq.ranking.Player;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

/**
 * Created by loicleger on 28/04/15.
 */
public class RankingTest {

    private Scoring s;
    private Ranking r;
    private Player player1;
    private Player player2;
    private Player player3;

    @Before
    public void setUp() throws BallInvalidException, GameInvalidException {
        s = new Scoring();
        r = new Ranking(s);
        player1 = new Player("p1",new Game(new StrikeFrame(),new StrikeFrame(),
                new StrikeFrame(),new StrikeFrame(),new StrikeFrame(),
                new StrikeFrame(),new StrikeFrame(),new StrikeFrame(),
                new StrikeFrame(),new LastStrikeFrame(Constants.NUMBER_OF_PINS,Constants.NUMBER_OF_PINS)));
        player2 = new Player("p2",new Game(new SpareFrame(4),new SpareFrame(4),
                new SpareFrame(4),new SpareFrame(4),new SpareFrame(4),
                new SpareFrame(4),new SpareFrame(4),new SpareFrame(4),
                new SpareFrame(4),new LastSpareFrame(4,4)));
        player3 = new Player("p3",new Game(new SpareFrame(4),new SpareFrame(4),
                new SpareFrame(4),new SpareFrame(4),new SpareFrame(4),
                new SpareFrame(4),new SpareFrame(8),new SpareFrame(4),
                new SpareFrame(4),new LastSpareFrame(4,4)));
    }

    @Test
    public void testRanking() {
        Player[] arrays = r.rank(player1, player2, player3);
        Player[] arraysOk = {player1,player3,player2};
        assertEquals(arraysOk,arrays);
    }
}

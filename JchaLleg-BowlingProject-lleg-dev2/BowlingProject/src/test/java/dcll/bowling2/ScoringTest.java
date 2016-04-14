package dcll.bowling2;

import dcll.ftsq.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by loicleger on 28/04/15.
 */
public class ScoringTest {

    private Scoring s;

    @Before
    public void setUp() throws BallInvalidException, GameInvalidException {
        s = new Scoring();
    }

    @Test
    public void testOpenFrame() throws Exception {
        Game g = new Game(new OpenFrame(4,4),new OpenFrame(4,4),
                new OpenFrame(4,4),new OpenFrame(4,4),new OpenFrame(4,4),
                new OpenFrame(4,4),new OpenFrame(4,4),new OpenFrame(4,4),
                new OpenFrame(4,4),new OpenFrame(4,4));
        assertEquals(80,s.calcScore(g));
    }

    @Test
    public void testSpareFrame() throws Exception {
        Game g = new Game(new SpareFrame(4),new SpareFrame(4),
                new SpareFrame(4),new SpareFrame(4),new SpareFrame(4),
                new SpareFrame(4),new SpareFrame(4),new SpareFrame(4),
                new SpareFrame(4),new LastSpareFrame(4,4));
        assertEquals(140,s.calcScore(g));
    }

    @Test
    public void testStrikeFrame() throws Exception {
        Game g = new Game(new StrikeFrame(),new StrikeFrame(),
                new StrikeFrame(),new StrikeFrame(),new StrikeFrame(),
                new StrikeFrame(),new StrikeFrame(),new StrikeFrame(),
                new StrikeFrame(),new LastStrikeFrame(Constants.NUMBER_OF_PINS,Constants.NUMBER_OF_PINS));
        assertEquals(300,s.calcScore(g));
    }
}

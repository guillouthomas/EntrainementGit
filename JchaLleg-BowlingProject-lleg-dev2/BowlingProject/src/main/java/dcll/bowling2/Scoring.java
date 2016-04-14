package dcll.bowling2;



import dcll.ftsq.InterfaceScore;
import dcll.ftsq.Game;
import dcll.ftsq.Frame;
import dcll.ftsq.LastStrikeFrame;
import dcll.ftsq.StrikeFrame;
import dcll.ftsq.OpenFrame;

/**
 * Created by loicleger on 28/04/15.
 */
public class Scoring implements InterfaceScore {

    @Override
    /**
     * @param game le jeu de la partoe
     * @return le score
     */
    public final int calcScore(final Game game) {
        int score = 0;
        for (Frame f : game.getFrames()) {
           if (!(f instanceof StrikeFrame) && !(f instanceof LastStrikeFrame)) {
               score += f.getBalls().get(0).getDownPins()
                       + f.getBalls().get(1).getDownPins();
               if (!(f instanceof OpenFrame)) {
                   score += f.getBonusBalls().get(0).getDownPins();
               }
           } else {
               score += f.getBalls().get(0).getDownPins();
               score += f.getBonusBalls().get(0).getDownPins()
                       + f.getBonusBalls().get(1).getDownPins();
           }
        }
        return score;
    }
}

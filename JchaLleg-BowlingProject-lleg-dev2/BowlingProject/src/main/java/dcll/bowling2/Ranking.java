package dcll.bowling2;

import dcll.ftsq.ranking.InterfaceRanking;
import dcll.ftsq.ranking.Player;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by loicleger on 28/04/15.
 */
public class Ranking implements InterfaceRanking {
    /**
     * the Scoring.
     */
    private Scoring score;

    /**
     *
     * @param s
     * constructor.
     */
    public Ranking(final Scoring s) {
        this.score = s;
    }

    @Override
    /**
     * Rank the players from their bowling score.
     * Example: if the score of Alice > the score of Bob,
     *   then this method should return {Alice, Bob}
     *   where {...} is a Player[] array.
     * @param array the input array of players
     * @return the array of players after ranking
     */
    public final Player[] rank(final Player... array) {
        Arrays.sort(array, new Comparator<Player>() {
            /**
             *
             * @param o1
             * @param o2
             * @return 1 if score o1 > score o2, 0 id score o1 = o2 , else -1.
             */
            @Override
            public int compare(final Player o1, final Player o2) {
                int score1 = score.calcScore(o1.getGame());
                int score2 = score.calcScore(o2.getGame());
                if (score1 > score2) {
                    return -1;
                } else {
                    return 1;
                }
            }
        });
        return array;
    }
}

package dcll.JchaLleg;

import dcll.ftsq.*;

import java.util.HashMap;
import java.util.List;
/** @author loicleger
 * Hello world!
 *
 */
public class ScoreCalculator implements InterfaceScore {
    /** attribut map pour gérer les points! */
    private HashMap<String, Integer> map;

    /** @value trois points*/
    public static final int TROIS = 3;
    /** @value quatre points */
    public static final int QUATRE = 4;
    /** @value cinq points */
    public static final int CINQ = 5;
    /** @value six points */
    public static final int SIX = 6;
    /** @value sept points */
    public static final int SEPT = 7;
    /** @value huit points */
    public static final int HUIT = 8;
    /** @value neuf points */
    public static final int NEUF = 9;
    /** @value dix points*/
    public static final int DIX = 10;

    /** Constructeur de la classe qui initialise la map!*/
    public ScoreCalculator() {
        map = new HashMap<String, Integer>();
        map.put("X", DIX);
        map.put("_", 0);
        map.put("0", 0);
        map.put("1", 1);
        map.put("2", 2);
        map.put("3", TROIS);
        map.put("4", QUATRE);
        map.put("5", CINQ);
        map.put("6", SIX);
        map.put("7", SEPT);
        map.put("8", HUIT);
        map.put("9", NEUF);
        map.put("/", DIX);
    }

    /** @param str la chaine du résultat de la partie
    *  @return le score calculé à partir de str */
    public final int calculerScoreSimple(final String str) {
        int score = 0;
        char[] temp = str.toCharArray();
        for (int i = 0; i < str.length(); i++) {
            score += Integer.parseInt(String.valueOf(temp[i]));
        }
        return score;
    }

    /** @param str la chaine du résultat de la partie
    *  @return le score calculé à partir de str */
    public final int calculerScoreSimpleAvecZero(final String str) {
        int score = 0;
        String[] temp = str.split("_");
        for (int i = 0; i < temp.length; i++) {
            score += Integer.parseInt(temp[i]);
        }
        return score;
    }

    /** @param str la chaine du résultat de la partie
     *  @return le score calculé à partir de str */
    public final int calculerScoreAvecStrike(final String str) {
        // Mise en place de la HashMap qui associe
        // les symboles et les String à des valeurs
        int score = 0;
        for (int i = 0; i < str.length(); i++) {
            score += this.map.get(str.substring(i, i + 1));
        }
        return score;
    }

    /** @param str la chaine du résultat de la partie
     *  @return le score calculé à partir de str */
    public final int
    calculerScoreAvecSpareSansStrikeSansCumul(final String str) {
        int score = 0;
        for (int i = 0; i < str.length() - 1;) {
            String premierLancer = str.substring(i, i + 1);
            String secondLancer = str.substring(i + 1, i + 2);
            score += this.map.get(premierLancer);
            score += this.map.get(secondLancer);
            if (secondLancer.equals("/")) {
                score -= this.map.get(premierLancer);
            }
            i += 2;
        }
        return score;
    }

    /** @param str la chaine du résultat de la partie
     *  @return le score calculé à partir de str
     *  @throws InvalideString if str est invalide
     *  @throws InvalideSize if str est trop court ou trop long */
    public final int calculerComplexeScoreSpareCumul(final String str)
            throws InvalideString, InvalideSize {
        this.validate(str);
        int score = 0;
        int limit = DIX;
        int testLimit = 0;
        for (int lancer = 0; lancer < str.length() - 1 && testLimit < limit;) {
            String premierLancer = str.substring(lancer, lancer + 1);
            String secondLancer;
            String premierLancerSuivant;
            String secondLancerSuivant;
            score += this.map.get(premierLancer);
            if (!premierLancer.equals("X")) {
                secondLancer = str.substring(lancer + 1, lancer + 2);
                score += this.map.get(secondLancer);
                if (secondLancer.equals("/")) {
                    score -= this.map.get(premierLancer);
                    premierLancerSuivant =
                            str.substring(lancer + 2, lancer + TROIS);
                    score += this.map.get(premierLancerSuivant);
                }
                lancer += 2;
            } else {
                premierLancerSuivant = str.substring(lancer + 1, lancer + 2);
                secondLancerSuivant = str.substring(lancer + 2, lancer + TROIS);
                score += this.map.get(premierLancerSuivant);
                score += this.map.get(secondLancerSuivant);
                if (secondLancerSuivant.equals("/")) {
                    score -= this.map.get(premierLancerSuivant);
                }
                lancer++;
            }
            testLimit++;
        }
        return score;
    }

    /** @param str la chaine du résultat de la partie
     *  @throws InvalideString if str est invalide
     *  @throws InvalideSize if str est trop court ou trop long */
    public final void validate(final String str)
            throws InvalideString, InvalideSize {
        int compteur = 0;
        for (int i = 0; i < str.length() - 1 && (compteur < DIX);) {
            String premierlancer = str.substring(i, i + 1);
            String secondlancer = str.substring(i + 1, i + 2);
            if (premierlancer.equals("/") || (!map.containsKey(premierlancer))
                    || (!map.containsKey(secondlancer))) {
                throw new InvalideString();
            }
            if (!premierlancer.equals("X")) {
                if ((!secondlancer.equals("X"))) {
                    if (!secondlancer.equals("/")) {
                        if ((map.get(premierlancer)
                                + map.get(secondlancer)) > DIX) {
                            throw new InvalideString();
                        }
                    }
                    compteur++;
                    if (compteur == DIX) {
                        if (secondlancer.equals("/")) {
                            if ((i + TROIS) != str.length()) {
                                throw new InvalideSize();
                            }
                            String dernierlancer =
                                    str.substring(i + 2, i + TROIS);
                            if (dernierlancer.equals("/")
                                    || (!map.containsKey(dernierlancer))) {
                                throw new InvalideString();
                            }
                        } else {
                            if ((i + 2) != str.length()) {
                                throw new InvalideSize();
                            }
                        }
                    }
                    i++;
                } else {
                    throw new InvalideString();
                }
            } else {
                compteur++;
                if (compteur == DIX) {
                    if ((i + TROIS) != str.length()) {
                        throw new InvalideSize();
                    }
                    String dernierlancer = str.substring(i + 2, i + TROIS);
                    if (!map.containsKey(dernierlancer)) {
                        throw new InvalideString();
                    }
                    if (secondlancer.equals("X")) {
                        if (dernierlancer.equals("/")) {
                            throw new InvalideString();
                        }
                    } else {
                        if (secondlancer.equals("/")
                                || dernierlancer.equals("X")) {
                            throw new InvalideString();
                        }
                    }
                }
            }
            i++;
        }
        if (compteur < DIX) {
            throw new InvalideSize();
        }
    }

    @Override
    public int calcScore(Game game) {
        int score =0;
        for(Frame f : game.getFrames()) {
            if (!(f instanceof StrikeFrame)) {
                score += f.getBalls().get(0).getDownPins() + f.getBalls().get(1).getDownPins();
                if (!(f instanceof OpenFrame)) {
                    score += f.getBonusBalls().get(0).getDownPins();
                }
            } else {
                score += f.getBalls().get(0).getDownPins();
                score += f.getBonusBalls().get(0).getDownPins() + f.getBonusBalls().get(1).getDownPins();
                }
            }
        return score;
    }
}

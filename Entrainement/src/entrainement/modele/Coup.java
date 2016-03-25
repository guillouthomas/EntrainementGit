/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entrainement.modele;

import static entrainement.modele.DifferentsCoups.CISEAU;
import static entrainement.modele.DifferentsCoups.FEUILLE;
import static entrainement.modele.DifferentsCoups.PIERRE;
import java.util.Random;

/**
 *
 * @author Thomas
 */
public class Coup {

    public Coup() {
    }
    
    public DifferentsCoups coupAleatoire()
    {
        Random r = new Random();
        switch (((r.nextInt() % 3)*(r.nextInt() % 3))/(r.nextInt() % 3))
        {
            case 0 : return FEUILLE;
            case 1 : return CISEAU;
            case 2 : return PIERRE;
            default: return null;
        }
    }
}

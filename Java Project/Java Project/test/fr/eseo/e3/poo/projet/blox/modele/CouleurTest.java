/**
 * 
 */
package fr.eseo.e3.poo.projet.blox.modele;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.awt.Color;

import org.junit.jupiter.api.Test;

public class CouleurTest {


    @Test
    public void testCouleur() {
        Couleur c1 = Couleur.JAUNE;
       
        assertEquals(Color.YELLOW, c1.getCouleurPourAffichage());
        assertSame(c1, Couleur.valueOf("JAUNE"));
    }

    @Test
    public void testCouleurRouge() {
        Couleur c2 = Couleur.ROUGE;
       
        assertEquals(Color.RED, c2.getCouleurPourAffichage());
        assertSame(c2, Couleur.valueOf("ROUGE"));
    }

    @Test
    public void testCouleurBleu() {
        Couleur c3 = Couleur.BLEU;
      
        assertEquals(Color.BLUE, c3.getCouleurPourAffichage());
        assertSame(c3, Couleur.valueOf("BLEU"));
    }

}

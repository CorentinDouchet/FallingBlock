package modele;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class CouleurTest {

    @Test
    public void testGetCouleurPourAffichage() {
        assertEquals(java.awt.Color.RED, Couleur.ROUGE.getCouleurPourAffichage());
        assertEquals(java.awt.Color.ORANGE, Couleur.ORANGE.getCouleurPourAffichage());
        assertEquals(java.awt.Color.BLUE, Couleur.BLEU.getCouleurPourAffichage());
        assertEquals(java.awt.Color.GREEN, Couleur.VERT.getCouleurPourAffichage());
        assertEquals(java.awt.Color.YELLOW, Couleur.JAUNE.getCouleurPourAffichage());
        assertEquals(java.awt.Color.CYAN, Couleur.CYAN.getCouleurPourAffichage());
        assertEquals(java.awt.Color.MAGENTA, Couleur.VIOLET.getCouleurPourAffichage());
    }
}

package fr.eseo.e3.poo.projet.blox.modele;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.awt.Color;

import org.junit.jupiter.api.Test;

public class CouleurTest {

	@Test
	void test() {
		Couleur color = Couleur.ROUGE;
		assertEquals(Color.RED,color.getCouleurPourAffichage());
		color = Couleur.BLEU;
		assertEquals(Color.BLUE,color.getCouleurPourAffichage());
		color = Couleur.CYAN;
		assertEquals(Color.CYAN,color.getCouleurPourAffichage());
		color = Couleur.JAUNE;
		assertEquals(Color.YELLOW,color.getCouleurPourAffichage());
		color = Couleur.ORANGE;
		assertEquals(Color.ORANGE,color.getCouleurPourAffichage());
		color = Couleur.VERT;
		assertEquals(Color.GREEN,color.getCouleurPourAffichage());
		color = Couleur.VIOLET;
		assertEquals(Color.MAGENTA,color.getCouleurPourAffichage());
		
		
	}

}

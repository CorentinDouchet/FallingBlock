package fr.eseo.e3.poo.projet.blox.vue;

import static org.junit.Assert.assertEquals;
import java.awt.Color;
import org.junit.jupiter.api.Test;
import fr.eseo.e3.poo.projet.blox.modele.Coordonnees;
import fr.eseo.e3.poo.projet.blox.modele.Couleur;
import fr.eseo.e3.poo.projet.blox.modele.pieces.OPiece;

public class VuePieceTest {

	@Test
	void test() {
		VuePiece vue = new VuePiece(new OPiece(new Coordonnees(0, 0),Couleur.BLEU),15);
		assertEquals(new Color(178,178,255),vue.teinte(Color.BLUE));

	}

}

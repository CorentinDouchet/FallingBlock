package fr.eseo.e3.poo.projet.blox.modele;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import fr.eseo.e3.poo.projet.blox.modele.pieces.OPiece;

public class TasTest {

	@Test
	void test() {
		Tas tas = new Tas(new Puits() , 10);
		new Tas(new Puits() , 1);
		new Tas(new Puits() , 2);
		new Tas(new Puits() , 3);
		new Tas(new Puits() , 4);
		Tas tas5 = new Tas(new Puits());
		assertEquals(tas5.getPuits().toString(), "Puits : Dimension 5 x 15\nPiece Actuelle : <aucune>\nPiece Suivante : <aucune>\n");
		tas5.getElements();
		tas5.setElements(5,15);
		tas5.setElements(1,1);
		tas.ajouterElements(new OPiece(new Coordonnees(3, 5),Couleur.CYAN));
		
		assertThrows(IllegalArgumentException.class, () -> {new Tas(new Puits() , 4000,1);});
		new Tas(new Puits() , 0,3);
	}
}

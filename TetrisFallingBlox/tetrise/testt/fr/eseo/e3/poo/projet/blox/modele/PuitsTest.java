package fr.eseo.e3.poo.projet.blox.modele;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import fr.eseo.e3.poo.projet.blox.modele.pieces.IPiece;
import fr.eseo.e3.poo.projet.blox.modele.pieces.OPiece;

public class PuitsTest {

	@Test
	void testElement() {
		Puits puit = new Puits();
		
		Puits puit2 = new Puits(15,20);
		Puits puit3 = new Puits(15,20);
		
		assertEquals("Puits : Dimension 5 x 15\nPiece Actuelle : <aucune>\nPiece Suivante : <aucune>\n", puit.toString());
		//Puits puit4 = new Puits(19, 20);
		assertEquals(15, puit.getProfondeur());
		assertEquals(5, puit.getLargeur());
		assertEquals(null, puit.getPieceActuelle());
		
		puit.setPieceSuivante(new IPiece(new Coordonnees(0, 0),Couleur.CYAN));
		puit.setPieceSuivante(new OPiece(new Coordonnees(0, 0),Couleur.ROUGE));
		assertEquals(new IPiece(new Coordonnees(2, -4),Couleur.CYAN).toString(),puit.getPieceActuelle().toString());
		assertEquals(new OPiece(new Coordonnees(0, 0),Couleur.ROUGE).toString(),puit.getPieceSuivante().toString());
		puit.setLargeur(8);
		puit.setProfondeur(21);
		assertEquals(21, puit.getProfondeur());
		assertEquals(8, puit.getLargeur());
		assertEquals(new Puits(15, 20).toString(),puit2.toString());
		puit3.setPieceSuivante(new IPiece(new Coordonnees(0, 0),Couleur.CYAN));
		puit3.setPieceSuivante(new OPiece(new Coordonnees(0, 0),Couleur.ROUGE));
		puit2.setPieceSuivante(new IPiece(new Coordonnees(0, 0),Couleur.CYAN));
		puit2.setPieceSuivante(new OPiece(new Coordonnees(0, 0),Couleur.ROUGE));
		assertEquals(puit3.toString(),puit2.toString());
        assertThrows(IllegalArgumentException.class, () -> {new Puits(0,50);});
        assertThrows(IllegalArgumentException.class, () -> {new Puits(0,20);});
        assertThrows(IllegalArgumentException.class, () -> {new Puits(0,0);});
        assertThrows(IllegalArgumentException.class, () -> {new Puits(45,15);});
        assertThrows(IllegalArgumentException.class, () -> {new Puits(45,0);});
        assertThrows(IllegalArgumentException.class, () -> {new Puits(45,45);});
        assertThrows(IllegalArgumentException.class, () -> {new Puits(10,0);});
        assertThrows(IllegalArgumentException.class, () -> {new Puits(10,45);});
        assertThrows(IllegalArgumentException.class, () -> {new Puits(0,50,1);});
        assertThrows(IllegalArgumentException.class, () -> {new Puits(0,20,1);});
        assertThrows(IllegalArgumentException.class, () -> {new Puits(0,0,1);});
        assertThrows(IllegalArgumentException.class, () -> {new Puits(45,15,1);});
        assertThrows(IllegalArgumentException.class, () -> {new Puits(45,0,1);});
        assertThrows(IllegalArgumentException.class, () -> {new Puits(45,45,1);});
        assertThrows(IllegalArgumentException.class, () -> {new Puits(10,0,1);});
        assertThrows(IllegalArgumentException.class, () -> {new Puits(10,45,1);});
        assertThrows(IllegalArgumentException.class, () -> {new Puits(0,50,1,1);});
        assertThrows(IllegalArgumentException.class, () -> {new Puits(0,20,1,1);});
        assertThrows(IllegalArgumentException.class, () -> {new Puits(0,0,1,1);});
        assertThrows(IllegalArgumentException.class, () -> {new Puits(45,15,1,1);});
        assertThrows(IllegalArgumentException.class, () -> {new Puits(45,0,1,1);});
        assertThrows(IllegalArgumentException.class, () -> {new Puits(45,45,1,1);});
        assertThrows(IllegalArgumentException.class, () -> {new Puits(10,0,1,1);});
        assertThrows(IllegalArgumentException.class, () -> {new Puits(10,45,1,1);});
        new Puits(10,20,1);
        assertThrows(IllegalArgumentException.class, () -> {puit.setLargeur(0);});
        assertThrows(IllegalArgumentException.class, () -> {puit.setLargeur(45);});
        assertThrows(IllegalArgumentException.class, () -> {puit.setProfondeur(0);});
        assertThrows(IllegalArgumentException.class, () -> {puit.setProfondeur(45);});
        puit.setPieceSuivante(UsineDePiece.genererPiece());
        puit.setPieceSuivante(UsineDePiece.genererPiece());
        puit.getPieceActuelle().setPosition(5, 17);
    	puit.gravite();
    	puit.gravite();
    	puit.gravite();
    	puit.gravite();
    	
	}
	@Test
	void testPuits() {
		Puits puit2 = new Puits(9, 16,10, 4);
		assertEquals("Puits : Dimension 9 x 16\nPiece Actuelle : <aucune>\nPiece Suivante : <aucune>\n", puit2.toString());
	}
	void testPuits2() {
		
	}
}

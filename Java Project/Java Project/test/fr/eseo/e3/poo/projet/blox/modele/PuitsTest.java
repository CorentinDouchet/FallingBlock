/**
 * 
 */
package fr.eseo.e3.poo.projet.blox.modele;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import fr.eseo.e3.poo.projet.blox.modele.pieces.IPiece;
import fr.eseo.e3.poo.projet.blox.modele.pieces.OPiece;
import fr.eseo.e3.poo.projet.blox.modele.pieces.Piece;

public class PuitsTest {

	@Test
	public void testConstructeursAccesseurs() {
		Puits p = new Puits();
		Puits p1 = new Puits(13, 17);
		assertEquals(p.LARGEUR_PAR_DEFAUT, p.getLargeur(), "Largeur OK");
		assertEquals(p.PROFONDEUR_PAR_DEFAUT, p.getProfondeur(), "Largeur OK");
		assertEquals(13, p1.getLargeur(), "Largeur OK");
		assertEquals(17, p1.getProfondeur(), "Largeur OK");

		assertThrows(IllegalArgumentException.class, () -> p.setLargeur(4));
		assertThrows(IllegalArgumentException.class, () -> p.setLargeur(16));

		assertThrows(IllegalArgumentException.class, () -> p.setProfondeur(14));
		assertThrows(IllegalArgumentException.class, () -> p.setProfondeur(26));

		Piece piece1 = new IPiece(new Coordonnees(2, 2), Couleur.ROUGE);
		Piece piece2 = new OPiece(new Coordonnees(3, 3), Couleur.JAUNE);
		p.setPieceSuivante(piece2);
		assertEquals(piece2, p.getPieceSuivante(), "Piece suivante Ok");
		assertNull(p.getPieceActuelle(), "Il ny'a plus de piece actuelle");
		p.setPieceSuivante(piece1);
		assertEquals(piece1, p.getPieceSuivante());
		assertEquals(new Coordonnees(p.getLargeur() / 2, -4), piece2.getElements().get(0).getCoordonnees());
		assertEquals(piece2, p.getPieceActuelle());

	}
   @Test 
   public void testToStringSansPieces() {
	   Puits p= new Puits();
	   String expected = "Puits : Dimension 10 x 15\n" +
               "Piece Actuelle : <aucune>\n" +
               "Piece Suivante : <aucune>\n";
       assertEquals(expected, p.toString());
	   
   }
   @Test 
   
   public void testToStringAvecPieces() {
	   Puits p1= new Puits();
	   Piece pieceSuivante = new IPiece(new Coordonnees(2, 7), Couleur.BLEU);
       p1.setPieceSuivante(pieceSuivante);
       String expected = "Puits : Dimension 10 x 15\n" +
               "Piece Actuelle : <aucune>\n" +
               "Piece Suivante : " + pieceSuivante.toString() ;
       assertEquals(expected, p1.toString());
   
}
}

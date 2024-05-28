package fr.eseo.e3.poo.projet.blox.modele;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import fr.eseo.e3.poo.projet.blox.modele.pieces.IPiece;
import fr.eseo.e3.poo.projet.blox.modele.pieces.JPiece;
import fr.eseo.e3.poo.projet.blox.modele.pieces.LPiece;
import fr.eseo.e3.poo.projet.blox.modele.pieces.OPiece;
import fr.eseo.e3.poo.projet.blox.modele.pieces.Piece;
import fr.eseo.e3.poo.projet.blox.modele.pieces.SPiece;
import fr.eseo.e3.poo.projet.blox.modele.pieces.TPiece;
import fr.eseo.e3.poo.projet.blox.modele.pieces.ZPiece;

public class UsineDePieceTest {
	@Test
    public void testGenererPieceCyclic() {
        UsineDePiece.setMode(UsineDePiece.CYCLIC);

        Piece piece1 = UsineDePiece.genererPiece();
        Piece piece2 = UsineDePiece.genererPiece();
        Piece piece3 = UsineDePiece.genererPiece();
        Piece piece4 = UsineDePiece.genererPiece();
        Piece piece5 = UsineDePiece.genererPiece();
        Piece piece6 = UsineDePiece.genererPiece();
        Piece piece7 = UsineDePiece.genererPiece();

        assertTrue(piece1 instanceof OPiece && piece1.getElements().get(0).getCouleur() == Couleur.ROUGE);
        assertTrue(piece2 instanceof IPiece && piece2.getElements().get(0).getCouleur() == Couleur.ORANGE);
        assertTrue(piece3 instanceof TPiece && piece3.getElements().get(0).getCouleur() == Couleur.BLEU);
        assertTrue(piece4 instanceof LPiece && piece4.getElements().get(0).getCouleur() == Couleur.VERT);
        assertTrue(piece5 instanceof JPiece && piece5.getElements().get(0).getCouleur() == Couleur.JAUNE);
        assertTrue(piece6 instanceof ZPiece && piece6.getElements().get(0).getCouleur() == Couleur.CYAN);
        assertTrue(piece7 instanceof SPiece && piece7.getElements().get(0).getCouleur() == Couleur.VIOLET);
    }
	@Test
    public void testGenererPieceAleatoirePiece() {
        UsineDePiece.setMode(UsineDePiece.ALEATOIRE_PIECE);
	    Boolean touePieceVu=false;
	    Boolean siOPiece=false;
	    Boolean siIPiece=false;
	    Boolean siTPiece=false;
	    Boolean siLPiece=false;
	    Boolean siJPiece=false;
	    Boolean siSPiece=false;
	    Boolean siZPiece=false;
        while (!touePieceVu) {
        	
        	Piece piece = UsineDePiece.genererPiece();
	        if (piece instanceof OPiece) {
	            assertEquals(Couleur.ROUGE, piece.getElements().get(0).getCouleur());
	            siOPiece=true;
	        } else if (piece instanceof IPiece) {
	            assertEquals(Couleur.ORANGE, piece.getElements().get(0).getCouleur());
	            siIPiece=true;
	        } else if (piece instanceof TPiece) {
	            assertEquals(Couleur.BLEU, piece.getElements().get(0).getCouleur());
	            siTPiece=true;
	        } else if (piece instanceof LPiece) {
	            assertEquals(Couleur.VERT, piece.getElements().get(0).getCouleur());
	            siLPiece=true;
	        } else if (piece instanceof JPiece) {
	            assertEquals(Couleur.JAUNE, piece.getElements().get(0).getCouleur());
	            siJPiece=true;
	        } else if (piece instanceof ZPiece) {
	            assertEquals(Couleur.CYAN, piece.getElements().get(0).getCouleur());
	            siZPiece=true;
	        } else if (piece instanceof SPiece) {
	            assertEquals(Couleur.VIOLET, piece.getElements().get(0).getCouleur());
	            siSPiece=true;
	        }
	        assertTrue(piece.getElements().get(0).getCoordonnees() != null && piece.getElements().get(0).getCoordonnees() instanceof Coordonnees);
	        if(siOPiece&&siIPiece&&siTPiece&&siLPiece&&siJPiece&&siSPiece&&siZPiece) {
	        	touePieceVu=true;
	        }
        }
    }    	
	@Test
    public void testGenererPieceAleatoireComplet() {
        UsineDePiece.setMode(UsineDePiece.ALEATOIRE_COMPLET);
		for(int i=0; i<10000;i++) {
			Piece piece = UsineDePiece.genererPiece();
	        assertTrue(piece.getElements().get(0).getCouleur() != null && piece.getElements().get(0).getCouleur() instanceof Couleur);
	        assertTrue(piece.getElements().get(0).getCoordonnees() != null && piece.getElements().get(0).getCoordonnees() instanceof Coordonnees);
	    	
		}
    }
}

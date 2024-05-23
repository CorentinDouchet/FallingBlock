/**
 * 
 */
package fr.eseo.e3.poo.projet.blox.modele;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import fr.eseo.e3.poo.projet.blox.modele.pieces.IPiece;
import fr.eseo.e3.poo.projet.blox.modele.pieces.OPiece;
import fr.eseo.e3.poo.projet.blox.modele.pieces.Piece;

public class UsineDePieceTest {
	void testAleatoireComplet() {
        UsineDePiece.setMode(UsineDePiece.ALEATOIRE_COMPLET);

        Piece p = UsineDePiece.genererPiece();

        assertNotNull(p,"OK");
        assertTrue(p instanceof Piece,"Piece OK");
    }

    @Test
    void testAleatoirePiece() {
        UsineDePiece.setMode(UsineDePiece.ALEATOIRE_PIECE);

        Piece p = UsineDePiece.genererPiece();

        assertNotNull(p);
        assertTrue(p instanceof Piece);
    }

    @Test
    void testCyclique() {
        UsineDePiece.setMode(UsineDePiece.CYCLIC);

        Piece p1 = UsineDePiece.genererPiece();
        Piece p2 = UsineDePiece.genererPiece();
        Piece p3 = UsineDePiece.genererPiece();

        assertTrue(p1 instanceof OPiece);
        assertTrue(p2 instanceof IPiece);
        assertTrue(p3 instanceof OPiece);
    }
}
	
	



package modele.pieces;

import modele.Coordonnees;
import modele.Couleur;
import modele.Element;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OPieceTest {
    private OPiece oPiece;

    @BeforeEach
    public void setUp() {
        oPiece = new OPiece(new Coordonnees(5, 5), Couleur.CYAN);
    }

    @Test
    public void testOPieceStructure() {
        assertEquals(4, oPiece.getElements().size(), "OPiece should have 4 elements.");
        
        // Il est important que la classe Coordonnees ait la méthode equals correctement implémentée
        assertEquals(new Coordonnees(5, 5), oPiece.getElements().get(0).getCoordonnees());
        assertEquals(new Coordonnees(6, 5), oPiece.getElements().get(1).getCoordonnees());
        assertEquals(new Coordonnees(5, 6), oPiece.getElements().get(2).getCoordonnees());
        assertEquals(new Coordonnees(6, 6), oPiece.getElements().get(3).getCoordonnees());
    }

    @Test
    public void testToString() {
        String expected = "OPiece :\n\t(5, 5) - CYAN\n\t(6, 5) - CYAN\n\t(5, 6) - CYAN\n\t(6, 6) - CYAN\n";
        String actual = oPiece.toString();
        assertEquals(expected, actual, "The toString output is not as expected.");
    }
}

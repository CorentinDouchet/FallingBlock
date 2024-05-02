package modele.pieces;

import modele.Coordonnees;
import modele.Couleur;
import modele.Element;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class IPieceTest {
    private IPiece iPiece;

    @BeforeEach
    public void setUp() {
        iPiece = new IPiece(new Coordonnees(5, 5), Couleur.ORANGE);
    }

    @Test
    public void testElementPositions() {
        assertEquals(4, iPiece.getElements().size(), "IPiece should have exactly 4 elements.");
        assertEquals(new Coordonnees(5, 4), iPiece.getElements().get(0).getCoordonnees());
        assertEquals(new Coordonnees(5, 5), iPiece.getElements().get(1).getCoordonnees()); // Référence
        assertEquals(new Coordonnees(5, 6), iPiece.getElements().get(2).getCoordonnees());
        assertEquals(new Coordonnees(5, 7), iPiece.getElements().get(3).getCoordonnees());
    }

    @Test
    public void testToString() {
        String expectedOutput = "IPiece :\n\t(5, 4) - ORANGE\n\t(5, 5) - ORANGE\n\t(5, 6) - ORANGE\n\t(5, 7) - ORANGE\n";
        String actualOutput = iPiece.toString();
        assertEquals(expectedOutput, actualOutput, "The toString method should output the correct format and data.");
    }
}

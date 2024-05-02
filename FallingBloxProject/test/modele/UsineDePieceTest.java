package modele;

import modele.pieces.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

public class UsineDePieceTest {

    @BeforeEach
    public void setup() {
        UsineDePiece.setMode(UsineDePiece.ALEATOIRE_PIECE); // Set a default mode before each test
        UsineDePiece.resetCyclicIndex(); // Resets the index for cyclic mode if method is available
    }

    @Test
    public void testGenererPieceAleatoireComplet() {
        UsineDePiece.setMode(UsineDePiece.ALEATOIRE_COMPLET);
        Set<Class<?>> pieceTypes = new HashSet<>();
        Set<Couleur> colors = new HashSet<>();

        // Generating multiple pieces to test randomness
        for (int i = 0; i < 100; i++) {
            Piece piece = UsineDePiece.genererPiece();
            assertNotNull(piece, "Piece should not be null");
            pieceTypes.add(piece.getClass());
            colors.add(piece.getElements().get(0).getCouleur());
        }

        // Check if multiple types and colors are used
        assertTrue(pieceTypes.size() > 1, "Should generate multiple types of pieces");
        assertTrue(colors.size() > 1, "Should generate pieces in multiple colors");
    }

    @Test
    public void testGenererPieceAleatoireType() {
        UsineDePiece.setMode(UsineDePiece.ALEATOIRE_PIECE);
        Set<Class<?>> pieceTypes = new HashSet<>();
        Set<Couleur> expectedColors = new HashSet<>();

        // Generating multiple pieces to test fixed color consistency
        for (int i = 0; i < 100; i++) {
            Piece piece = UsineDePiece.genererPiece();
            assertNotNull(piece, "Piece should not be null");
            pieceTypes.add(piece.getClass());
            piece.getElements().forEach(element -> expectedColors.add(element.getCouleur()));
        }

        assertEquals(1, expectedColors.size(), "All pieces should have the same color");
        assertTrue(pieceTypes.size() > 1, "Should generate multiple types of pieces with fixed colors");
    }

    @Test
    public void testGenererPieceCyclique() {
        UsineDePiece.setMode(UsineDePiece.CYCLIC);
        Class<?>[] expectedSequence = {OPiece.class, IPiece.class}; // Add other classes as needed
        int sequenceIndex = 0;

        for (int i = 0; i < expectedSequence.length * 2; i++) { // Test two full cycles
            Piece piece = UsineDePiece.genererPiece();
            assertNotNull(piece, "Piece should not be null");
            assertEquals(expectedSequence[sequenceIndex], piece.getClass(), "Pieces should follow the cyclic sequence");
            sequenceIndex = (sequenceIndex + 1) % expectedSequence.length;
        }
    }

    @Test
    public void testInvalidModeSetting() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> UsineDePiece.setMode(999));
        assertTrue(exception.getMessage().contains("Mode non supporté"), "Should throw an exception for invalid modes");
    }
}

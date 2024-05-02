package modele;

import modele.pieces.*;
import java.util.Random;

public class UsineDePiece {
    public static final int ALEATOIRE_COMPLET = 0;
    public static final int ALEATOIRE_PIECE = 1;
    public static final int CYCLIC = 2;

    private static final Random random = new Random();
    private static int mode = ALEATOIRE_PIECE;
    private static int lastPieceIndex = 0; // To keep track of the last piece type created in CYCLIC mode
    private static Class<?>[] pieceTypes = {OPiece.class, IPiece.class}; // Add more piece types as necessary
    private static Couleur[] fixedColors = {Couleur.ROUGE, Couleur.BLEU}; // Fixed colors corresponding to the piece types

    private UsineDePiece() {
        // Private constructor to prevent instantiation
    }

    public static void setMode(int newMode) {
        if (newMode < ALEATOIRE_COMPLET || newMode > CYCLIC) {
            throw new IllegalArgumentException("Mode non supporté");
        }
        mode = newMode;
        if (mode == CYCLIC) {
            lastPieceIndex = 0; // Reset the index when switching to cyclic mode
        }
    }

    public static Piece genererPiece() {
        Coordonnees coord = new Coordonnees(2, 3);
        switch (mode) {
            case ALEATOIRE_COMPLET:
                return genererPieceAleatoire(coord);
            case ALEATOIRE_PIECE:
                return genererPieceAleatoireType(coord);
            case CYCLIC:
                return genererPieceCyclique(coord);
            default:
                throw new IllegalStateException("Mode de génération inconnu");
        }
    }

    private static Piece genererPieceAleatoire(Coordonnees coord) {
        int typeIndex = random.nextInt(pieceTypes.length);
        Couleur couleur = Couleur.values()[random.nextInt(Couleur.values().length)];
        return createPieceInstance(pieceTypes[typeIndex], coord, couleur);
    }

    private static Piece genererPieceAleatoireType(Coordonnees coord) {
        int typeIndex = random.nextInt(pieceTypes.length);
        Couleur couleur = fixedColors[typeIndex]; // Use predefined colors for consistency
        return createPieceInstance(pieceTypes[typeIndex], coord, couleur);
    }

    private static Piece genererPieceCyclique(Coordonnees coord) {
        Piece piece = createPieceInstance(pieceTypes[lastPieceIndex], coord, fixedColors[lastPieceIndex]);
        lastPieceIndex = (lastPieceIndex + 1) % pieceTypes.length;
        return piece;
    }

    private static Piece createPieceInstance(Class<?> pieceClass, Coordonnees coord, Couleur couleur) {
        try {
            return (Piece) pieceClass.getConstructor(Coordonnees.class, Couleur.class).newInstance(coord, couleur);
        } catch (Exception e) {
            throw new RuntimeException("Error creating piece instance", e);
        }
    }

    public static void resetCyclicIndex() {
        lastPieceIndex = 0; // Method to reset the cyclic index for test setups
    }
}

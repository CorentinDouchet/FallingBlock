package modele;
import modele.pieces.Piece;

public class Puits {
    public static final int LARGEUR_PAR_DEFAUT = 10;
    public static final int PROFONDEUR_PAR_DEFAUT = 20;

    private int largeur;
    private int profondeur;
    private Piece pieceActuelle;
    private Piece pieceSuivante;

    public Puits() {
        this(LARGEUR_PAR_DEFAUT, PROFONDEUR_PAR_DEFAUT);
    }

    public Puits(int largeur, int profondeur) {
        setLargeur(largeur);
        setProfondeur(profondeur);
    }

    public Piece getPieceActuelle() {
        return pieceActuelle;
    }

    public Piece getPieceSuivante() {
        return pieceSuivante;
    }

    public void setPieceSuivante(Piece piece) {
        if (this.pieceSuivante != null) {
            this.pieceActuelle = this.pieceSuivante;
            this.pieceActuelle.setPosition(largeur / 2, -4);
        }
        this.pieceSuivante = piece;
    }

    public int getLargeur() {
        return largeur;
    }

    public void setLargeur(int largeur) {
        if (largeur < 5 || largeur > 15) {
            throw new IllegalArgumentException("Largeur invalide, doit être entre 5 et 15.");
        }
        this.largeur = largeur;
    }

    public int getProfondeur() {
        return profondeur;
    }

    public void setProfondeur(int profondeur) {
        if (profondeur < 15 || profondeur > 25) {
            throw new IllegalArgumentException("Profondeur invalide, doit être entre 15 et 25.");
        }
        this.profondeur = profondeur;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Puits : Dimension ").append(largeur).append(" x ").append(profondeur).append("\n");
        sb.append("Piece Actuelle : ").append(pieceActuelle != null ? pieceActuelle.toString() : "<aucune>").append("\n");
        sb.append("Piece Suivante : ").append(pieceSuivante != null ? pieceSuivante.toString() : "<aucune>");
        return sb.toString();
    }
}

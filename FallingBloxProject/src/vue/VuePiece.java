package vue;

import java.awt.Color;
import java.awt.Graphics2D;
import modele.pieces.Piece;
import modele.Element;

public class VuePiece {
    public static final double MULTIPLIER_TEINTE = 0.3; // Teinte claire pour l'élément de référence
    private final Piece piece;
    private final int taille; // Taille en pixels d'un élément

    public VuePiece(Piece piece, int taille) {
        this.piece = piece;
        this.taille = taille;
    }

    public Color teinte(Color couleur) {
        // Méthode pour éclaircir une couleur
        int r = couleur.getRed();
        int g = couleur.getGreen();
        int b = couleur.getBlue();
        int alpha = couleur.getAlpha();

        r = (int)(r + (255 - r) * MULTIPLIER_TEINTE);
        g = (int)(g + (255 - g) * MULTIPLIER_TEINTE);
        b = (int)(b + (255 - b) * MULTIPLIER_TEINTE);

        return new Color(r, g, b, alpha);
    }

    public void afficherPiece(Graphics2D g2D) {
        int index = 0;
        for (Element element : piece.getElements()) {
            Color color = element.getCouleur().getCouleurPourAffichage();
            if (index == 0) {  // Supposons que le premier élément est toujours l'élément de référence
                color = teinte(color);
            }
            g2D.setColor(color);
            g2D.fill3DRect(element.getCoordonnees().getAbscisse() * taille,
                           element.getCoordonnees().getOrdonnee() * taille,
                           taille, taille, true);
            index++;
        }
    }
}

/**
 * 
 */
package fr.eseo.e3.poo.projet.blox.vue;

import java.awt.Color;
import java.awt.Graphics2D;

import fr.eseo.e3.poo.projet.blox.modele.Element;
import fr.eseo.e3.poo.projet.blox.modele.pieces.Piece;


public class VuePiece {

	public static final double MULTIPLIER_TEINTE = 0.6;

	private final Piece piece;
	private int taille;

	// private Element e;

	public VuePiece(Piece piece, int taille) {
		this.piece = piece;
		this.taille = taille;
		

	}

	public Color teinte(Color couleur) {
		int red = (int) (couleur.getRed() + (255 - couleur.getRed()) * MULTIPLIER_TEINTE);
		int green = (int) (couleur.getGreen() + (255 - couleur.getGreen()) * MULTIPLIER_TEINTE);
		int blue = (int) (couleur.getBlue() + (255 - couleur.getBlue()) * MULTIPLIER_TEINTE);
		return new Color(red, green, blue);
	}

	public void afficherPiece(Graphics2D g2d) {

		for (Element element : piece.getElements()) {
			int x = element.getCoordonnees().getAbscisse() * taille;
			int y = element.getCoordonnees().getOrdonnee() * taille;
			if(g2d!=null) {
				
			Color	couleur = piece.getElements().get(0).getCouleur().getCouleurPourAffichage();
			g2d.setColor(element == piece.getElements().get(0) ? teinte(couleur) : couleur);
				g2d.fill3DRect(x, y, taille, taille, true);
				
			}
		}
	
	}
}

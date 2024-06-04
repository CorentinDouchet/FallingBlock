package fr.eseo.e3.poo.projet.blox.vue;

import java.awt.Color;
import java.awt.Graphics2D;

import fr.eseo.e3.poo.projet.blox.modele.Element;
import fr.eseo.e3.poo.projet.blox.modele.pieces.Piece;

public class VuePiece {
	public static final double MULTIPLIER_TEINTE=0.7;
	private final Piece piece;
	private final int taille;
	
	public VuePiece(Piece piece, int taille) {
		this.piece = piece;
		this.taille=taille;
	}
	
	public Color teinte (Color couleur ) {
		int r = couleur.getRed();
		int g = couleur.getGreen();
		int b = couleur.getBlue();
		r=(int)(r+(255-r)*MULTIPLIER_TEINTE);
		g=(int)(g+(255-g)*MULTIPLIER_TEINTE);
		b=(int)(b+(255-b)*MULTIPLIER_TEINTE);
		return new Color(r,g,b,couleur.getAlpha());
	}
	public void afficherPiece(Graphics2D g2D) {
		Element element;
		int y;
		int x;
		
		element=piece.getElements().get(0);
		g2D.setColor(teinte (element.getCouleur().getCouleurPourAffichage()));
		x=element.getCoordonnees().getAbscisse();
		y=element.getCoordonnees().getOrdonnee();
		g2D.fill3DRect(x*taille, y*taille, taille, taille, true);
		
		for(int i=1;i<piece.getElements().size();i++) {
			element=piece.getElements().get(i);
			g2D.setColor(element.getCouleur().getCouleurPourAffichage());
			x=element.getCoordonnees().getAbscisse();
			y=element.getCoordonnees().getOrdonnee();
			g2D.fill3DRect(x*taille, y*taille, taille, taille, true);
		}
	}
	
}

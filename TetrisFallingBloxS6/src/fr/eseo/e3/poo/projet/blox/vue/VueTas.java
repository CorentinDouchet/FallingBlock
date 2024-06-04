package fr.eseo.e3.poo.projet.blox.vue;

import java.awt.Color;
import java.awt.Graphics2D;

import fr.eseo.e3.poo.projet.blox.modele.Tas;

public class VueTas {
	private Tas tas;
	public static final double MULTIPLIER_TEINTE=0;
	private final VuePuits vuePuits;
	public VueTas(VuePuits vuePuits) {
		this.vuePuits = vuePuits;
		tas=this.vuePuits.getPuits().getTas();
		
	}
	public Color nuance(Color couleur) {
		int r = couleur.getRed();
		int g = couleur.getGreen();
		int b = couleur.getBlue();
		r=(int)(r*(1-MULTIPLIER_TEINTE));
		g=(int)(g*(1-MULTIPLIER_TEINTE));
		b=(int)(b*(1-MULTIPLIER_TEINTE));
		return new Color(r,g,b,couleur.getAlpha());
	}
	public void affichage(Graphics2D g2D) {
		for (int i=0;i<this.tas.getElements().length;i++) {
			for (int j=0;j<this.tas.getElements()[1].length;j++) {
				if(this.tas.getElements()[i][j]!= null) {
					int x,y, taille;
					x=this.tas.getElements()[i][j].getCoordonnees().getAbscisse();
					taille = this.vuePuits.getTaille();
					y= this.tas.getElements()[i][j].getCoordonnees().getOrdonnee();
					g2D.setColor(nuance(this.tas.getElements()[i][j].getCouleur().getCouleurPourAffichage()));
					g2D.fill3DRect(x*taille,y*taille, taille, taille, true);
				}
			}
		}
	}
	public VuePuits getVuePuits(){
		return this.vuePuits;
	}
}

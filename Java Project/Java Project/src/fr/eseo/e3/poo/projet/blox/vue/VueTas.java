/**
 * 
 */
package fr.eseo.e3.poo.projet.blox.vue;

import java.awt.Color;
import java.awt.Graphics2D;

import fr.eseo.e3.poo.projet.blox.modele.Element;
import fr.eseo.e3.poo.projet.blox.modele.Tas;

public class VueTas {
	public static final double MULTIPLIER_NUANCE = 0.7;

    private final Tas tas;
    private final VuePuits vuePuits;

    public VueTas(VuePuits vuePuits) {
        this.tas = vuePuits.getPuits().getTas();
        this.vuePuits = vuePuits;
    }

    public Color nuance(Color color) {
        int red = (int) (color.getRed() * (1 - MULTIPLIER_NUANCE));
        int green = (int) (color.getGreen() * (1 - MULTIPLIER_NUANCE));
        int blue = (int) (color.getBlue() * (1 - MULTIPLIER_NUANCE));
        return new Color(red, green, blue);
    }

    public void afficher(Graphics2D g2d) {
    	  int tailleElement = getVuePuits().getTaille();
          Element[][] elements = tas.getElements();
          for (int i = 0; i < elements.length; i++) {
              for (int j = 0; j < elements[i].length; j++) {
                  Element element = elements[i][j];
                  if (element != null) {
                      Color couleur = element.getCouleur().getCouleurPourAffichage();
                    Color couleurNuancée = nuance(couleur);
                      g2d.setColor(couleurNuancée);
                      g2d.fill3DRect(tailleElement*j , tailleElement*i, tailleElement,tailleElement, true);
                  }
              }
          }
       
        
    }

    public Tas getTas() {
        return tas;
    }

    public VuePuits getVuePuits() {
        return vuePuits;
    }

}

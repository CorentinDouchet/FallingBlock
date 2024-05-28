package fr.eseo.e3.poo.projet.blox.vue;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanneauInformation extends JPanel {
	
	/**
	 * affichage d'un panneau
	 */
	private static final long serialVersionUID = 1L;
	VuePuits vuepuit;
	public PanneauInformation(VuePuits vuePuit) {
		this.vuepuit = vuePuit;
		JLabel infoS = new JLabel ( "PanneauInformation" ) ;
		this.setBackground(Color.WHITE);
		this.setPreferredSize (new Dimension (150,this.vuepuit.getPuits().getProfondeur()*vuePuit.getTaille())) ;
		this.add(infoS);
	}
	
	
}

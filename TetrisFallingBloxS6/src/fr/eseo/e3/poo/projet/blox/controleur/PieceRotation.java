package fr.eseo.e3.poo.projet.blox.controleur;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.SwingUtilities;


import fr.eseo.e3.poo.projet.blox.modele.BloxException;
import fr.eseo.e3.poo.projet.blox.modele.Puits;
import fr.eseo.e3.poo.projet.blox.vue.VuePuits;
//gere les clics de la souris et permet de tourner les pieces
public class PieceRotation extends MouseAdapter{
	private VuePuits vuePuits;
	private Puits puits;
	
	public PieceRotation(VuePuits vuePuits)  {
		this.vuePuits = vuePuits;
		this.puits = vuePuits.getPuits();
		this.vuePuits.addMouseListener(this);
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		if(SwingUtilities.isLeftMouseButton(e)) {
			try {
				puits.getPieceActuelle().tourner(false);
			}catch (BloxException ej) {
				if(ej.getType()==1)
					System.out.println("vous avez touche un cote");
				if(ej.getType()==0)
					System.out.println("vous avez touche le tas");
			}
			finally {
				this.vuePuits.updateUI();
			}
		}
		if(SwingUtilities.isRightMouseButton(e)) {
			try {
				puits.getPieceActuelle().tourner(true);
			}catch (BloxException ej) {
				if(ej.getType()==1)
					System.out.println("vous avez touche un cote");
				if(ej.getType()==0)
					System.out.println("vous avez touche le tas");
			}
			finally {
				this.vuePuits.updateUI();
			}
		}
		this.vuePuits.updateUI();

	}
	
    public void tourner(boolean sensHoraire) {
        try {
        	vuePuits.getPuits().getPieceActuelle().tourner(sensHoraire);
        } catch (BloxException e) {
            // Gérer l'exception si nécessaire
        }
    }
}

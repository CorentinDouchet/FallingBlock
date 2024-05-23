
package fr.eseo.e3.poo.projet.blox.controleur;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.SwingUtilities;

import fr.eseo.e3.poo.projet.blox.modele.BloxException;
import fr.eseo.e3.poo.projet.blox.modele.Puits;
import fr.eseo.e3.poo.projet.blox.modele.pieces.Piece;
import fr.eseo.e3.poo.projet.blox.vue.VuePuits;

public class PieceRotation extends MouseAdapter {
	

    private  VuePuits vuePuits;
    private Puits puits;
    private boolean rotationPossible = true;

    public PieceRotation(VuePuits vuePuits) {
        this.vuePuits = vuePuits;
        this.puits=vuePuits.getPuits();
    }
    @Override
    public void mouseClicked(MouseEvent event) {
        if (rotationPossible && event.getButton() != MouseEvent.NOBUTTON) {
            Piece piece = this.vuePuits.getPuits().getPieceActuelle();
            boolean clockwise = SwingUtilities.isRightMouseButton(event);
            boolean counterclockwise = SwingUtilities.isLeftMouseButton(event);
            if (clockwise ^ counterclockwise) { // XOR to check that only one button is pressed
                try {
					piece.tourner(clockwise);
				} catch (BloxException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }else {
                try {
					piece.tourner(counterclockwise);
				} catch (BloxException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
                this.vuePuits.repaint();
            }
        }
        vuePuits.repaint();
    }
    
}


/**
 * 
 */
package fr.eseo.e3.poo.projet.blox.vue;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JPanel;

import fr.eseo.e3.poo.projet.blox.modele.Puits;
import fr.eseo.e3.poo.projet.blox.modele.pieces.Piece;


	public class PanneauInformation extends JPanel implements PropertyChangeListener {

	    private static final long serialVersionUID = 1L;
	    
	    private VuePiece vuePiece;
	    
	    public PanneauInformation(Puits puits) {
	        super();
	        setPreferredSize(new Dimension(70, 70));
	        puits.addPropertyChangeListener(this);
	    }

	    @Override
	    public void propertyChange(PropertyChangeEvent evt) {
	        if ("prochainePiece".equals(evt.getPropertyName())) {
	            Piece nouvellePiece = (Piece) evt.getNewValue();
	            vuePiece = new VuePiece(nouvellePiece, 10);
	        }
	    }
	    
	    protected void paintComponent(Graphics2D g) {
	        super.paintComponent(g);
	        if (vuePiece != null) {
	            vuePiece.afficherPiece(g);
	        }
	    }

	}



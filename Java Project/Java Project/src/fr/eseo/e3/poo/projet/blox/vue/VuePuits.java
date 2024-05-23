/**
 * 
 */
package fr.eseo.e3.poo.projet.blox.vue;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JPanel;

import fr.eseo.e3.poo.projet.blox.controleur.Gravite;
import fr.eseo.e3.poo.projet.blox.controleur.PieceDeplacement;
import fr.eseo.e3.poo.projet.blox.controleur.PieceRotation;
import fr.eseo.e3.poo.projet.blox.modele.Element;
import fr.eseo.e3.poo.projet.blox.modele.Puits;
import fr.eseo.e3.poo.projet.blox.modele.pieces.Piece;

public class VuePuits extends JPanel implements PropertyChangeListener {
	private static final long serialVersionUID = 1L;

	public static final int TAILLE_PAR_DEFAUT = 15;
	private Puits puits;
	private VuePiece vuePiece;
	@SuppressWarnings("unused")
	private int tailleElement = TAILLE_PAR_DEFAUT;

	private final VueTas vueTas;

	private Gravite gravite;

	public VuePuits(Puits puits) {
		this(puits, TAILLE_PAR_DEFAUT);

	}

	public VuePuits(Puits puits, int taille) {
		this.setPuits(puits);
		this.setTaille(taille);
		this.vuePiece = null;

		// puits.addPropertyChangeListener(this);
		this.setPreferredSize(new Dimension(puits.getLargeur() * tailleElement, puits.getProfondeur() * tailleElement));
		this.setBackground(Color.WHITE);
		this.vueTas = new VueTas(this);
		this.gravite = new Gravite(this);
		puits.addPropertyChangeListener(this);

		PieceDeplacement pieceDeplacement = new PieceDeplacement(this);

		this.addMouseMotionListener(pieceDeplacement);
		this.addMouseListener(pieceDeplacement);
		this.addMouseWheelListener(pieceDeplacement);
		PieceRotation rotation = new PieceRotation(this);
		this.addMouseListener(rotation);

	}

	public void propertyChange(PropertyChangeEvent event) {
		if (Puits.MODIFICATION_PIECE_ACTUELLE.equals(event.getPropertyName())) {
			// changer la vue de la pièce actuelle
			setVuePiece(new VuePiece((Piece) event.getNewValue(), this.tailleElement));

		}

	}

	public int getTaille() {
		return this.tailleElement;
	}

	public void setTaille(int taille) {
		this.tailleElement = taille;
		this.setPreferredSize(new Dimension(puits.getLargeur() * tailleElement, puits.getProfondeur() * tailleElement));
		// revalidate();
		repaint();
	}

	public Puits getPuits() {
		return puits;
	}

	public VueTas getVueTas() {
		return this.vueTas;
	}

	public void setVueTas(VueTas vueTas) {
		vueTas = vueTas;
	}

	public void setPuits(Puits p) {
		this.puits = p;
		this.setPreferredSize(new Dimension(puits.getLargeur() * tailleElement, puits.getProfondeur() * tailleElement));
		this.repaint();

	}

	public VuePiece getVuePiece() {
		return vuePiece;
	}

	private void setVuePiece(VuePiece nouvellevuePiece) {
		this.vuePiece = nouvellevuePiece;

	}
	

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);// arrière plan par défaut
		Graphics2D g2d = (Graphics2D) g.create();
		g.setColor(Color.LIGHT_GRAY);

		for (int x = 0; x <= puits.getLargeur(); x++) {
			g.drawLine(x * getTaille(), 0, x * getTaille(), puits.getProfondeur() * getTaille());
		}
		for (int y = 0; y <= puits.getProfondeur(); y++) {
			g.drawLine(0, y * getTaille(), puits.getLargeur() * getTaille(), y * getTaille());
		}
		

		if (vueTas != null && puits.getTas().getNbre() != 0 && puits.getTas()!=null &&puits!=null ) {
			this.getVueTas().afficher(g2d);
			
		}
		if (vuePiece != null) {

			this.vuePiece.afficherPiece(g2d);

			
		}
		
		repaint();

		g2d.dispose();
	}
}


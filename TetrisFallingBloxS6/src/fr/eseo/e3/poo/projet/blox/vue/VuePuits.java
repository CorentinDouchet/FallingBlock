package fr.eseo.e3.poo.projet.blox.vue;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JPanel;

import fr.eseo.e3.poo.projet.blox.controleur.PieceDeplacement;
import fr.eseo.e3.poo.projet.blox.controleur.PieceRotation;
import fr.eseo.e3.poo.projet.blox.modele.Puits;


public class VuePuits extends JPanel implements PropertyChangeListener{
	public static final int TAILLE_PAR_DEFAUT=15;
	private int taille;
	private Puits puits;
	private VuePiece vuePiece;
	private PieceDeplacement pieceDeplacement;
	private PieceRotation pieceRotation;
	private final VueTas vueTas;
	public VuePuits(Puits puits) {
		this(puits, TAILLE_PAR_DEFAUT);
	}
	public VuePuits(Puits puits, int taille) {
		this.taille=taille;
		this.puits=puits;
		this.setPreferredSize (new Dimension (taille* puits.getLargeur(),taille*puits.getProfondeur())) ;
		this.setBackground(Color.WHITE);
		this.vueTas=new VueTas(this);
		this.puits.addPropertyChangeListener(this);
		this.pieceDeplacement = new PieceDeplacement(this);
		this.pieceRotation = new PieceRotation(this);
        setFocusable(true); // Permet à JPanel de recevoir des événements clavier
        requestFocusInWindow(); // Demande le focus pour recevoir les événements clavier

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_LEFT: // Flèche gauche
                        pieceDeplacement.deplacer(-1, 0);
                        break;
                    case KeyEvent.VK_RIGHT: // Flèche droite
                        pieceDeplacement.deplacer(1, 0);
                        break;
                    case KeyEvent.VK_DOWN: // Flèche bas
                        pieceDeplacement.deplacer(0, 1);
                        break;
                    case KeyEvent.VK_UP: // Flèche haut pour la rotation
                        pieceRotation.tourner(true);
                        break;
                }
                repaint(); // Redessine le composant après le mouvement ou la rotation
            }
        });
    }		
	
	
	public int getTaille() {	
		return taille;
	}
	public void setTaille(int taille) {
		this.taille = taille;
		this.setPreferredSize (new Dimension (taille* puits.getLargeur(),taille*puits.getProfondeur())) ;
	}
	public Puits getPuits() {
		return puits;
	}
	public void setPuits(Puits puits) {
		this.puits = puits;
		this.setPreferredSize (new Dimension (taille* puits.getLargeur(),taille*puits.getProfondeur())) ;
	}
	public VuePiece getVuePiece() {
		return this.vuePiece;
	}
	private void setVuePiece(VuePiece vuePiece) {
		this.vuePiece = vuePiece;
	}	

	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		/* appel vers super pour remplir le fond du JPanel */
		/*Le paramètre g est copie en utilisant la méthode copie()
		* puis converti en instance de Graphics2D grâce à
		* un transtypage (cast) explicite.
		*/
		Graphics2D g2D = (Graphics2D)g.create();
		/* Nous utiliserons l'instance de Graphics2D*/
		/*Puis nous liberons la memoire*/
		g2D.setColor(Color.LIGHT_GRAY);
		for (int x=0;x<puits.getLargeur(); x++) {
			for (int z=0;z<puits.getProfondeur(); z++) {
				g2D.drawLine(x*this.getTaille(), 0, x*this.getTaille(), this.getTaille()*puits.getProfondeur());
				g2D.drawLine(0, z*this.getTaille(), this.getTaille()*puits.getLargeur(), z*this.getTaille());
				
			}
		}
		if(vuePiece!=null) {
			vuePiece.afficherPiece(g2D);
		}
		if(vueTas!=null) {
			vueTas.affichage(g2D);
		}
		g2D.dispose();
		
		
	}
	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		if(evt.getPropertyName().compareTo("Piece_actuelle")==0) {
			setVuePiece(new VuePiece(puits.getPieceActuelle(), this.getTaille()));
		}
	}
	public VueTas getVueTas() {
		return this.vueTas;
	}
}

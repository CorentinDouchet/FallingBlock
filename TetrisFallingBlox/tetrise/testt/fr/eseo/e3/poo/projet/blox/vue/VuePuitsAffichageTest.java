package fr.eseo.e3.poo.projet.blox.vue;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import org.junit.jupiter.api.Test;

import fr.eseo.e3.poo.projet.blox.controleur.Gravite;
import fr.eseo.e3.poo.projet.blox.modele.Puits;
import fr.eseo.e3.poo.projet.blox.modele.UsineDePiece;
import fr.eseo.e3.poo.projet.blox.modele.pieces.Piece;

public class VuePuitsAffichageTest {
	public VuePuitsAffichageTest() {
		testConstructeurPuits();
		testConstructeurPuitsTaille();
		}
	@Test
	private void testConstructeurPuits() {
		JFrame fenetre = new JFrame("Puits");
		Puits puit = new Puits();
		VuePuits vue = new VuePuits(puit);
		
		puit.addPropertyChangeListener(vue);
		UsineDePiece.setMode(2);
		Piece piece = UsineDePiece.genererPiece();
		puit.setPieceSuivante(piece);
		piece = UsineDePiece.genererPiece();
		puit.setPieceSuivante(piece);
		piece = UsineDePiece.genererPiece();
		puit.setPieceSuivante(piece);
		puit.getPieceActuelle().setPosition(2, 2);
		new Gravite(vue);
		fenetre.add (vue);
		fenetre.setDefaultCloseOperation ( JFrame . EXIT_ON_CLOSE ) ;
		fenetre.pack () ;
		fenetre.setLocationRelativeTo(null);
		fenetre.setVisible ( true ) ;
	}
	@Test
	private void testConstructeurPuitsTaille() {
		JFrame fenetre = new JFrame("Puits et taille");
		Puits puit = new Puits(10,20);
		VuePuits vue = new VuePuits(puit,25);
		puit.addPropertyChangeListener(vue);
		
		UsineDePiece.setMode(2);
		Piece piece = UsineDePiece.genererPiece();
		puit.setPieceSuivante(piece);
		piece = UsineDePiece.genererPiece();
		puit.setPieceSuivante(piece);
		puit.getPieceActuelle().setPosition(2, 2);
		new Gravite(vue);
		fenetre.add (vue);
		fenetre.setDefaultCloseOperation ( JFrame . EXIT_ON_CLOSE ) ;
		fenetre.pack () ;
		fenetre.setLocationRelativeTo(null);
		fenetre.setVisible ( true ) ;
	}
		
		
	public static void main (String [] args) {
		SwingUtilities.invokeLater(new Runnable () {
			@Override
			public void run() {
				new VuePuitsAffichageTest ();
			}});
	}

}

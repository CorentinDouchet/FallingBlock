package fr.eseo.e3.poo.projet.blox.controleur;


import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import org.junit.jupiter.api.Test;

import fr.eseo.e3.poo.projet.blox.modele.Puits;
import fr.eseo.e3.poo.projet.blox.modele.UsineDePiece;
import fr.eseo.e3.poo.projet.blox.modele.pieces.Piece;
import fr.eseo.e3.poo.projet.blox.vue.VuePuits;

public class PieceDeplacementTest {

	
	public PieceDeplacementTest() {
		testConstructeur();
		}
	@Test
	private void testConstructeur() {
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
				new PieceDeplacementTest ();
			}});
	}
}

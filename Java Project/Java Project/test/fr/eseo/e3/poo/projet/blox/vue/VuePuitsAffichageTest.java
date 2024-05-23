/**
 * 
 */
package fr.eseo.e3.poo.projet.blox.vue;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import fr.eseo.e3.poo.projet.blox.modele.BloxException;
import fr.eseo.e3.poo.projet.blox.modele.Puits;
import fr.eseo.e3.poo.projet.blox.modele.UsineDePiece;
import fr.eseo.e3.poo.projet.blox.modele.pieces.Piece;

public class VuePuitsAffichageTest {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				new VuePuitsAffichageTest();
			}
		});

	}

	private VuePuits vuePuits;

	public VuePuitsAffichageTest() {
		testConstructeurPuits();
		testConstructeurPuitsTaille();
		testConstructeurTas();
	}

	private void testConstructeurPuits() {

		JFrame frame = new JFrame("Puits");
		Puits puits = new Puits();
		vuePuits = new VuePuits(puits, 20);
		puits.addPropertyChangeListener(vuePuits);
		UsineDePiece.setMode(3);
		Piece piece = UsineDePiece.genererPiece();
		// piece.tourner(true);
		puits.setPieceSuivante(piece);
		puits.setPieceSuivante(piece);
		puits.getPieceActuelle().setPosition(5, 5);
		System.out.println(puits.getPieceActuelle());
		// VuePiece vuePiece = new VuePiece(piece, vuePuits.TAILLE_PAR_DEFAUT);
		// vuePuits.setVuePiece(vuePiece);

		frame.add(vuePuits);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.repaint();

	}

	private void testConstructeurPuitsTaille() {
		JFrame frame = new JFrame("Puits et taille");
		UsineDePiece.setMode(3);
		Piece piece = UsineDePiece.genererPiece();

		// piece.tourner(false);
		Puits puits = new Puits();

		vuePuits = new VuePuits(puits);
		puits.addPropertyChangeListener(vuePuits);
		puits.setPieceSuivante(piece);
		// VuePiece vuePiece = new VuePiece(piece,vuePuits.TAILLE_PAR_DEFAUT);
		// vuePuits.setVuePiece(vuePiece);

		frame.add(vuePuits);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.repaint();

	}

	private void testConstructeurTas() {
		JFrame frame = new JFrame("Tas");

		Puits puits = new Puits();

		vuePuits = new VuePuits(puits);
		puits.addPropertyChangeListener(vuePuits);
		for (int i = 0; i < puits.getTas().getElements().length; i++) {
			for (int j = 0; i < puits.getTas().getElements().length; i++) {
				System.out.println(puits.getTas().getElements()[i][j].toString());
			}
		}
		//vuePuits.getPuits().getTas();
		frame.add(vuePuits);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.repaint();
	}

}

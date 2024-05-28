package fr.eseo.e3.poo.projet.blox.vue;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import fr.eseo.e3.poo.projet.blox.controleur.Gravite;
import fr.eseo.e3.poo.projet.blox.modele.Puits;
import fr.eseo.e3.poo.projet.blox.modele.UsineDePiece;
import fr.eseo.e3.poo.projet.blox.modele.pieces.Piece;

public class FallingBloxVersion1 {
	private FallingBloxVersion1(Puits puit) {
		JFrame fenetre = new JFrame("Falling Blox");
		VuePuits vue = new VuePuits(puit);
		puit.addPropertyChangeListener(vue);
		UsineDePiece.setMode(2);
		Piece piece = UsineDePiece.genererPiece();
		puit.setPieceSuivante(piece);
		piece = UsineDePiece.genererPiece();
		puit.setPieceSuivante(piece);
		puit.getPieceActuelle().setPosition(2, 2);
		fenetre.add( new PanneauInformation(vue), BorderLayout . EAST );
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
				Puits puit;
				if(args.length==1) {
					puit = new Puits(10,20,Integer.parseInt(args[0]));
				}
				if(args.length==2) {
					puit = new Puits(10,20,Integer.parseInt(args[0]),Integer.parseInt(args[0]));
				}
				else {
					puit = new Puits(10,20);
				}
				new FallingBloxVersion1(puit);
			}});
	}

}

package fr.eseo.e3.poo.projet.blox.controleur;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import org.junit.jupiter.api.Test;

import fr.eseo.e3.poo.projet.blox.modele.Puits;
import fr.eseo.e3.poo.projet.blox.modele.UsineDePiece;
import fr.eseo.e3.poo.projet.blox.modele.pieces.Piece;
import fr.eseo.e3.poo.projet.blox.vue.VuePuits;

public class GraviteTest {
    private VuePuits vuePuits;
   public GraviteTest() {
	   testConstructor();
   }
    @Test
    public void testConstructor() {
        JFrame fenetre = new JFrame("Puits");
		Puits puit = new Puits();
		vuePuits = new VuePuits(puit);
		UsineDePiece.setMode(2);
		Piece piece = UsineDePiece.genererPiece();
		puit.setPieceSuivante(piece);
		piece = UsineDePiece.genererPiece();
		puit.setPieceSuivante(piece);
		piece = UsineDePiece.genererPiece();
		puit.setPieceSuivante(piece);
		puit.getPieceActuelle().setPosition(2, 2);
		new Gravite(vuePuits);
        fenetre.add (vuePuits);
		fenetre.setDefaultCloseOperation ( JFrame . EXIT_ON_CLOSE ) ;
		fenetre.pack () ;
		fenetre.setLocationRelativeTo(null);
		fenetre.setVisible ( true ) ;
        
    }

	public static void main (String [] args) {
		SwingUtilities.invokeLater(new Runnable () {
			@Override
			public void run() {
				new GraviteTest ();
			}});
	}
}

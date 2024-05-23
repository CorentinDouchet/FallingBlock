/**
 * 
 */
package fr.eseo.e3.poo.projet.blox.controleur;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import fr.eseo.e3.poo.projet.blox.modele.Coordonnees;
import fr.eseo.e3.poo.projet.blox.modele.Couleur;
import fr.eseo.e3.poo.projet.blox.modele.Puits;
import fr.eseo.e3.poo.projet.blox.modele.UsineDePiece;
import fr.eseo.e3.poo.projet.blox.modele.pieces.IPiece;
import fr.eseo.e3.poo.projet.blox.vue.VuePuits;

public class PieceRotationTest {
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				new PieceRotationTest();
			}
		});

	}


	

	
	public PieceRotationTest(){ 
		testRotationPiece();
	}
	private void testRotationPiece() {
		JFrame j=new JFrame(" Rotation Piece ");
		j.setLayout(new BorderLayout());
		Puits puits=new Puits(15,20);
		VuePuits v=new VuePuits(puits,20);
		//PieceDeplacement pd=new PieceDeplacement(v);
		puits.addPropertyChangeListener(v);
		
		//PanneauInformation 
		UsineDePiece.setMode(2);
		puits.setPieceSuivante(new IPiece(new Coordonnees(5,5),Couleur.BLEU));
		puits.setPieceSuivante(new IPiece(new Coordonnees(5,5),Couleur.BLEU));
		puits.getPieceActuelle().setPosition(5, 5);
		System.out.println(puits.getPieceActuelle());
		
		j.add(v,BorderLayout.WEST);
		
		
		j.setSize(v.getPreferredSize());
		j.pack();
		j.setLocationRelativeTo(null);
		j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		j.setVisible(true);
		j.repaint();
	}
		
		
	}


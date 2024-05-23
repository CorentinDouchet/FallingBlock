package fr.eseo.e3.poo.projet.blox.controleur;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import fr.eseo.e3.poo.projet.blox.modele.Puits;
import fr.eseo.e3.poo.projet.blox.modele.UsineDePiece;
import fr.eseo.e3.poo.projet.blox.vue.VuePuits;

public class PieceDeplacementTest {
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				new PieceDeplacementTest();
			}
		});

	}


	

	
	public PieceDeplacementTest(){ 
		testDeplacementHorizontale();
	}
	
	private void testDeplacementHorizontale() {
		JFrame j=new JFrame(" Déplacement horizontal ");
		j.setLayout(new BorderLayout());
		Puits puits=new Puits(15,20);
		VuePuits v=new VuePuits(puits,20);
		//PieceDeplacement pd=new PieceDeplacement(v);
		puits.addPropertyChangeListener(v);
		
		//PanneauInformation 
		UsineDePiece.setMode(2);
		puits.setPieceSuivante(UsineDePiece.genererPiece());
		puits.setPieceSuivante(UsineDePiece.genererPiece());
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
package fr.eseo.e3.poo.projet.blox.vue;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import org.junit.jupiter.api.Test;

import fr.eseo.e3.poo.projet.blox.modele.Puits;

public class VueTasTest {
	public VueTasTest() {
		test();
		}
	@Test
	private void test() {
		JFrame fenetre = new JFrame("vue tas");
		Puits puit = new Puits(10,20,99,10);
		VuePuits vue = new VuePuits(puit);
		new VueTas(vue).getVuePuits();
		puit.addPropertyChangeListener(vue);
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
				new VueTasTest ();
			}});
	}


}

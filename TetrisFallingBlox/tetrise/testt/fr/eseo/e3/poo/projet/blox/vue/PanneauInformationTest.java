package fr.eseo.e3.poo.projet.blox.vue;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import org.junit.jupiter.api.Test;

import fr.eseo.e3.poo.projet.blox.modele.Puits;

public class PanneauInformationTest {
	public PanneauInformationTest() {
		test();
		}
	
	
	@Test
	private void test() {
		JFrame fenetre = new JFrame("test panneau info");
		VuePuits vue = new VuePuits(new Puits(10,20));
		fenetre.add( new PanneauInformation(vue));
		fenetre.setDefaultCloseOperation ( JFrame . EXIT_ON_CLOSE ) ;
		fenetre.pack () ;
		fenetre.setLocationRelativeTo(null);
		fenetre.setVisible ( true ) ;
	}
	
	
public static void main (String [] args) {
	SwingUtilities.invokeLater(new Runnable () {
		@Override
		public void run() {
			new PanneauInformationTest();
		}});
}
	
}

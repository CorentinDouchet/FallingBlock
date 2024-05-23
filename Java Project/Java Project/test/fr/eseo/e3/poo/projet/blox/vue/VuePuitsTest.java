/**
 * 
 */
package fr.eseo.e3.poo.projet.blox.vue;


import java.awt.Dimension;
import java.util.Random;

import  org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import fr.eseo.e3.poo.projet.blox.modele.Puits;

public class VuePuitsTest {
 private Puits puits;
 private VuePuits vuePuits;

	    @BeforeEach
	    public void setUp() {
	        puits = new Puits(10, 20);
	        vuePuits = new VuePuits(puits);
	    }

	    @Test
	    public void testConstructeurAvecUnSeulParametre() {
	        Assertions.assertEquals(VuePuits.TAILLE_PAR_DEFAUT, vuePuits.getTaille(),"OK");

	        Dimension taillePreferee = vuePuits.getPreferredSize();
	        Assertions.assertNotNull(taillePreferee);
	        Assertions.assertEquals(10 * VuePuits.TAILLE_PAR_DEFAUT, taillePreferee.width);
	        Assertions.assertEquals(20 * VuePuits.TAILLE_PAR_DEFAUT, taillePreferee.height);
	    }

	    @Test
	    public void testConstructeurAvecDeuxParametres() {
	        int taille = new Random().nextInt(100) + 1;
	        vuePuits = new VuePuits(puits, taille);

	        Assertions.assertEquals(taille, vuePuits.getTaille());

	        Dimension taillePreferee = vuePuits.getPreferredSize();
	        Assertions.assertNotNull(taillePreferee);
	        Assertions.assertEquals(10 * taille, taillePreferee.width);
	        Assertions.assertEquals(20 * taille, taillePreferee.height);
	    }

	    @Test
	    public void testAccesseurs() {
	        Assertions.assertEquals(puits, vuePuits.getPuits());
	        Assertions.assertEquals(VuePuits.TAILLE_PAR_DEFAUT, vuePuits.getTaille());

	        int taille = new Random().nextInt(100) + 1;
	        vuePuits.setTaille(taille);
	        Assertions.assertEquals(taille, vuePuits.getTaille());
	    }
}

	    /*@Test
	    public void testPaintComponent() {
	        JFrame frame = new JFrame("Test VuePuits");
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        frame.getContentPane().add(vuePuits);
	        frame.pack();
	        frame.setVisible(true);

	        try {
	            Thread.sleep(500); // Attendre 500ms pour que la fenêtre s'affiche
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }

	        // Vérifier que la grille s'affiche correctement
	        Graphics g = vuePuits.getGraphics();
	        Assertions.assertNotNull(g);
	        g.setColor(Color.BLACK);
	        g.drawLine(0, 0, 10, 10); // Dessiner une ligne noire pour tester que la grille est affichée par dessus
	        try {
	            Thread.sleep(500); // Attendre 500ms pour que la grille s'affiche
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }

	        int taille = vuePuits.getTaille();
	        for (int i = 0; i < puits.getLargeur(); i++) {
	            for (int j = 0; j < puits.getProfondeur(); j++) {
	                int x = i * taille;
	                int y = j * taille;
	                Color expectedColor = ((i + j) % 2 == 0) ? Color.LIGHT_GRAY : Color.WHITE;
	                Color actualColor = new Color(vuePuits.getRGB(x, y));
	               Assertions. assertEquals(expectedColor, actualColor);


}
	        }*/
	    

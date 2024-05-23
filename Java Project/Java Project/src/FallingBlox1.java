import java.awt.BorderLayout;

import javax.swing.JFrame;

import fr.eseo.e3.poo.projet.blox.modele.Puits;
import fr.eseo.e3.poo.projet.blox.vue.PanneauInformation;
import fr.eseo.e3.poo.projet.blox.vue.VuePuits;

public class FallingBlox1 {
	 public static void main(String[] args) {
	        int tasSize = 0;
	        int puitsHeight = 20;
	        
	        if (args.length == 1) {
	            tasSize = Integer.parseInt(args[0]);
	        } else if (args.length == 2) {
	            tasSize = Integer.parseInt(args[0]);
	            puitsHeight = Integer.parseInt(args[1]);
	        }
	        
	        Puits puits = new Puits(puitsHeight, tasSize);
	        VuePuits vuePuits = new VuePuits(puits);
	        PanneauInformation panneauInformation = new PanneauInformation(puits);
	        
	        JFrame frame = new JFrame("Falling Blox");
	        frame.setLayout(new BorderLayout());
	        frame.add(vuePuits, BorderLayout.CENTER);
	        frame.add(panneauInformation, BorderLayout.EAST);
	        frame.setResizable(false);
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        frame.pack();
	        frame.setLocationRelativeTo(null);
	        
	        //vuePuits.commencerPartie();
	        frame.setVisible(true);

}
}


package fr.eseo.e3.poo.projet.blox.controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import fr.eseo.e3.poo.projet.blox.modele.BloxException;
import fr.eseo.e3.poo.projet.blox.modele.Puits;
import fr.eseo.e3.poo.projet.blox.vue.VuePuits;

public class Gravite implements ActionListener {

	private static final int PERIODICITE_TIMER = 500; // en millisecondes
	    
	    private VuePuits vuePuits;
	    private Puits puits;
	    private Timer timer;
	    
	    public Gravite(VuePuits vuePuits) {
	        this.vuePuits = vuePuits;
	       
	        this.timer = new Timer(PERIODICITE_TIMER, this);
	        this.timer.start();
	    }

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
	    
	  //  @Override
	   /* public void actionPerformed(ActionEvent e) {
	        try {
				//this.puits.gravite();
			} catch (BloxException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	        this.vuePuits.repaint();
	    }
	    
	    public void setPeriodicite(int millisecondes) {
	        this.timer.setDelay(millisecondes);
	    }
	    
	    public int getPeriodicite() {
	        return this.timer.getDelay();
	    }*/

}

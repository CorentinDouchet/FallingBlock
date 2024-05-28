package fr.eseo.e3.poo.projet.blox.controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import fr.eseo.e3.poo.projet.blox.modele.Puits;
import fr.eseo.e3.poo.projet.blox.vue.VuePuits;
//pemret de faire tomber les piece tout x temps
public class Gravite implements ActionListener{
	private Timer timer;
	private VuePuits vuePuits; 
	private Puits puits;
	private int periodicite;
	public Gravite (VuePuits vuePuits) {
		this.vuePuits = vuePuits;
		this.puits = this.vuePuits.getPuits();
		periodicite=1000;
		timer= new Timer(getPeriodicite(), this);
		timer.start();
	}
	public int getPeriodicite () {
		return this.periodicite;
	}
	public void setPeriodicite (int periodicite) {
		this.periodicite = periodicite;
	}
	public void actionPerformed (ActionEvent event) {
		this.vuePuits.repaint();
		this.puits.gravite();
		
	}
}

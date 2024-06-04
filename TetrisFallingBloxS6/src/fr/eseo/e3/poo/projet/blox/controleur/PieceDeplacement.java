package fr.eseo.e3.poo.projet.blox.controleur;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;

import fr.eseo.e3.poo.projet.blox.modele.Coordonnees;
import fr.eseo.e3.poo.projet.blox.modele.Puits;
import fr.eseo.e3.poo.projet.blox.vue.VuePuits;
import fr.eseo.e3.poo.projet.blox.modele.BloxException;
//gere les deplacement de la souris pour le jeu
public class PieceDeplacement extends MouseAdapter {
	private VuePuits vuePuits;
	private Puits puits;
	private Coordonnees coordsPrems=null;
	public PieceDeplacement(VuePuits vuePuits) {
		this.vuePuits = vuePuits;
		this.puits = vuePuits.getPuits();
		this.vuePuits.addMouseMotionListener(this);
		this.vuePuits.addMouseListener(this);
		this.vuePuits.addMouseWheelListener(this);
	}
	@Override
	public void mouseMoved(MouseEvent e) {
		int tailleE= vuePuits.getTaille();
		if(puits.getPieceActuelle()!=null) {	
			Coordonnees coordsMouseNew = new Coordonnees(e.getX()/tailleE, e.getY()/tailleE);
			if (coordsPrems==null) {
				coordsPrems=coordsMouseNew;
				
			}else if(coordsPrems.getAbscisse()!=coordsMouseNew.getAbscisse()) {
				try {
					puits.getPieceActuelle().deplacerDe(coordsMouseNew.getAbscisse()-coordsPrems.getAbscisse(),0);
				}catch (BloxException ey) {
					if(ey.getType()==1)
						System.out.println(ey);
					if(ey.getType()==0)
						System.out.println(ey);
				}
				
				this.vuePuits.updateUI();
				
			}
			coordsPrems.setAbscisse(coordsMouseNew.getAbscisse());	
		}	
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		if (coordsPrems==null) {
			coordsPrems=new Coordonnees(e.getX()/vuePuits.getTaille(), e.getY()/vuePuits.getTaille());
		}
		coordsPrems.setAbscisse(e.getX()/vuePuits.getTaille());
	}
	@Override
	public void mouseWheelMoved(MouseWheelEvent e) {
		if (coordsPrems==null) {
			coordsPrems=new Coordonnees(e.getX()/vuePuits.getTaille(), e.getY()/vuePuits.getTaille());
		}
		if(puits.getPieceActuelle()!=null) {
			if(e.getWheelRotation()>0) {
				try {
					puits.getPieceActuelle().deplacerDe(0,1);
				}catch (BloxException ej) {
					if(ej.getType()==1)
						System.out.println(ej);
					if(ej.getType()==0)
						System.out.println(ej);
				}
				this.vuePuits.updateUI();
				
				
			}
		}
	} 
    public void deplacer(int deltaX, int deltaY) {
        try {
        	vuePuits.getPuits().getPieceActuelle().deplacerDe(deltaX, deltaY);
        } catch (BloxException e) {
            // Gérer l'exception si nécessaire
        }
    }	

}



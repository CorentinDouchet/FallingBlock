package fr.eseo.e3.poo.projet.blox.controleur;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;

import fr.eseo.e3.poo.projet.blox.modele.BloxException;
import fr.eseo.e3.poo.projet.blox.modele.Puits;
import fr.eseo.e3.poo.projet.blox.modele.pieces.Piece;
import fr.eseo.e3.poo.projet.blox.vue.VuePuits;

public class PieceDeplacement extends MouseAdapter {
	private  VuePuits vuePuits;
	private  Puits puits;

	private int lastColumn = -1;

	public PieceDeplacement(VuePuits vuePuits) {
		this.vuePuits = vuePuits;
		this.puits = vuePuits.getPuits();

	}

	@Override
	public void mouseMoved(MouseEvent e) {
		if (getPuits().getPieceActuelle() != null) {
			int column = getColumnFromMouseEvent(e);
			System.out.println("moved");
			if (lastColumn == -1) {
				lastColumn = column;
			} else if (column != lastColumn) {
				int a = this.getColumnFromMouseEvent(e) - lastColumn;
				int b = (a != 0) ? Math.abs(a) / a : a;
				try {

					try {
						getPuits().getPieceActuelle().deplacerDe(b, 0);
					} catch (BloxException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					lastColumn = column;
					this.vuePuits.repaint();
				} catch (IllegalArgumentException exception) {
					System.out.println("Deplacement impossible");
				}
			}
		}
	}
	public int getLastColumn() {
		return lastColumn;
	}

	private int getColumnFromMouseEvent(MouseEvent e) {
		int mouseX = e.getX();
		int columnWidth = vuePuits.getTaille();
		return mouseX / columnWidth;
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// Ne rien faire
	}
	public  void mouseEntered(MouseEvent e) {
		lastColumn = getColumnFromMouseEvent(e);
		}
	
	public void mouseWheelMoved(MouseWheelEvent e) {
		
		  if (getPuits().getPieceActuelle() != null  ) {

				System.out.println("MWM: "+e.getWheelRotation());
			  if(e.getWheelRotation()>0) {
				Piece  piece=getPuits().getPieceActuelle();
				  try {
					  try {
						this.getPuits().getPieceActuelle().deplacerDe(0, 1);
					} catch (BloxException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				  }catch(IllegalArgumentException exception) {
						System.out.println("Deplacement impossible") ;
					 
				  }
			  }
	           
	        }
		 vuePuits.repaint();
		
	}

	

	
	public Puits getPuits() {
		return puits;
	}

 void setPuits(Puits puits) {
		this.puits = puits;
	}
}
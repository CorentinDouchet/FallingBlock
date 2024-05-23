/**
 * 
 */
package fr.eseo.e3.poo.projet.blox.modele;
import java.beans.PropertyChangeSupport;
import java.util.Objects;

import fr.eseo.e3.poo.projet.blox.modele.pieces.Piece;

public class Puits {

public static final int LARGEUR_PAR_DEFAUT=10;
public static final int PROFONDEUR_PAR_DEFAUT=15;
public static final String MODIFICATION_PIECE_ACTUELLE = "Modification de la pièce actuelle";
public static final String MODIFICATION_PIECE_SUIVANTE = "Modification de la pièce suivante";

private  PropertyChangeSupport pcs;
private int largeur;
private int profondeur;
private Piece pieceActuelle;
private Piece pieceSuivante;
private Tas tas;
	public Puits() {
		this(LARGEUR_PAR_DEFAUT, PROFONDEUR_PAR_DEFAUT);
		 this.tas = new Tas(this);
		
		  pcs = new PropertyChangeSupport(this);
		
		
		
	}
	
 public Puits(int largeur, int profondeur) {
	       setLargeur(largeur);
	       setProfondeur(profondeur);
	       this.tas = new Tas(this);
	       pcs = new PropertyChangeSupport(this);
	       
	        }
 public Puits(int largeur,int profondeur,int nbElements,int nbRows) {
	 setLargeur(largeur);
     setProfondeur(profondeur);
	 
	 
	 this.tas = new Tas(this, nbElements, nbRows);
	 pcs = new PropertyChangeSupport(this);
 }
	        
 public Piece getPieceActuelle() {
	        return pieceActuelle;
	    }
public void setPieceActuelle(Piece nouvellePiece) {
	 Piece anciennePiece = pieceActuelle;
     pieceActuelle = nouvellePiece;
     pcs.firePropertyChange(MODIFICATION_PIECE_ACTUELLE, anciennePiece, nouvellePiece);
}
	 
 
	    
	    public Piece getPieceSuivante() {
	        return pieceSuivante;
	    }
	    
	    public void setPieceSuivante(Piece nouvellePiece) {
	    
	        
	        if(pieceSuivante != null) {
	        	Piece anciennePiece = pieceActuelle;
	            pieceActuelle = pieceSuivante;
	            pieceActuelle.setPosition(largeur/2, -4);
	            pcs.firePropertyChange(MODIFICATION_PIECE_ACTUELLE, anciennePiece, pieceActuelle);
	            
	        }
	        pieceSuivante = Objects.requireNonNull(nouvellePiece, "La pièce suivante ne doit pas être null");
	        Piece anciennePiece = pieceSuivante;
	        pieceSuivante = nouvellePiece;
	        pcs.firePropertyChange(MODIFICATION_PIECE_SUIVANTE, anciennePiece, nouvellePiece);
	        this.pieceSuivante.setPuits(this);
	    }
	   
		
	    
	    public int getLargeur() {
	        return largeur;
	    }
	    
	    public void setLargeur(int largeur) {
	        if(largeur < 5 || largeur > 15) {
	            throw new IllegalArgumentException("La largeur doit être entre 5 et 15");
	        }
	        this.largeur = largeur;
	    }
	    
	    public int getProfondeur() {
	        return profondeur;
	    }  
	    
	    public void setProfondeur(int profondeur) {
	        if(profondeur < 15 || profondeur > 25) {
	            throw new IllegalArgumentException("La profondeur doit être entre 15 et 25");
	        }
	        this.profondeur = profondeur;
	    }
	    public Tas getTas() {
	    	return this.tas;
	    }
	    public void setTas(Tas tas) {
	        this.tas = tas;
	    }
	    
	    public void addPropertyChangeListener(java.beans.PropertyChangeListener listener) {
	        pcs.addPropertyChangeListener(listener);
	    }
	    
	    public void removePropertyChangeListener(java.beans.PropertyChangeListener listener) {
	        pcs.removePropertyChangeListener(listener);
	    }
	    
	    @Override
	    public String toString() {
	        StringBuilder builder = new StringBuilder();
	        builder.append("Puits : Dimension ").append(largeur).append(" x ").append(profondeur).append("\n");
	        builder.append("Piece Actuelle : ").append(pieceActuelle == null ? "<aucune>"+"\n": pieceActuelle).append("");
	        builder.append("Piece Suivante : ").append(pieceSuivante == null ? "<aucune>"+"\n" : pieceSuivante);
	        return builder.toString();
	    }
/*
		private void gererCollision() {
			 this.tas.ajouterElements(this.pieceActuelle);
		        this.pieceActuelle = this.pieceSuivante;
		        this.pieceSuivante = UsineDePiece.genererPiece();
		
			
		}
		public void gravite()  throws BloxException {
	        try {
	            this.pieceActuelle.deplacerDe(0, 1);
	            for (Element e : elements) {
	    			int newX = e.getCoordonnees().getAbscisse() + deltax;
	    			int newY = e.getCoordonnees().getOrdonnee() + deltay;
	            }
	         catch (Exception e) {
	            if () {
	                this.gererCollision();
	            } else if () {
	                this.gererCollision();
	            } else {
	                throw e;
	            }
	        }
			
		}

		

	}*/
}




package fr.eseo.e3.poo.projet.blox.modele;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

import fr.eseo.e3.poo.projet.blox.modele.pieces.Piece;

public class Puits {
	
	public static final int LARGEUR_PAR_DEFAUT = 5;
	public static final int PROFONDEUR_PAR_DEFAUT = 15;
	private Piece pieceActuelle;
	private Piece pieceSuivante;
	private int largeur;
	private int profondeur;
	private Tas tas;
	public static final String MODIFICATION_PIECE_ACTUELLE="Piece_actuelle";
	public static final String MODIFICATION_PIECE_SUIVANTE="Piece_Suivante";
	private PropertyChangeSupport pcs= new PropertyChangeSupport(this);
    private int score = 0;
	public Puits() {
		this.largeur = LARGEUR_PAR_DEFAUT;
		this.profondeur = PROFONDEUR_PAR_DEFAUT;
		this.tas = new Tas(this);
	}
	public Puits(int largeur, int profondeur) {
		if((4<largeur&&largeur<16)&&(14<profondeur&&profondeur<26)) {
			this.largeur = largeur;
			this.profondeur = profondeur;
			tas = new Tas(this);
		}
		else{
			throw new IllegalArgumentException("les tailles ne sont pas bonne, veillez réessayer");
		}
	}
	public Puits(int largeur, int profondeur, int nbElements) {
		if((5<=largeur&&largeur<=15)&&(15<=profondeur&&profondeur<=25)) {
			this.largeur = largeur;
			this.profondeur = profondeur;
			tas = new Tas(this,nbElements);
		}
		else{
			throw new IllegalArgumentException("les tailles ne sont pas bonne, veillez réessayer");
		}
	}
	public Puits(int largeur, int profondeur, int nbElements,int nbLignes) {
		if((5<=largeur&&largeur<=15)&&(15<=profondeur&&profondeur<=25)) {
			this.largeur = largeur;
			this.profondeur = profondeur;
			tas = new Tas(this,nbElements, nbLignes);
		}
		else{
			throw new IllegalArgumentException("les tailles ne sont pas bonne, veillez réessayer");
		}
	}
	public Piece getPieceActuelle() {
		return pieceActuelle;
	}
	
	public Piece getPieceSuivante() {
		return pieceSuivante;
	}
	
	public void setPieceSuivante(Piece pieceSuivante) {
		
		if (this.pieceSuivante!=null) {
			Piece old = this.pieceActuelle;
			this.pieceActuelle=this.pieceSuivante;
			this.pieceActuelle.setPuits(this);
			pieceActuelle.setPosition(largeur/2,-4);
			this.pcs.firePropertyChange(MODIFICATION_PIECE_ACTUELLE, old, this.pieceSuivante);
			
		}
		Piece old2 = this.pieceSuivante;
		this.pieceSuivante=pieceSuivante;
		this.pcs.firePropertyChange(MODIFICATION_PIECE_SUIVANTE, old2, pieceSuivante);
		
	}
	
	public int getLargeur() {
		return largeur;
	}
	public void setLargeur(int largeur) {
		if(5<=largeur&&largeur<=15){
			this.largeur = largeur;
			this.getTas().setElements(largeur, this.profondeur);
		}
		else{
			throw new IllegalArgumentException("les tailles ne sont pas bonne, veillez réessayer");
		}
	}
	
	public int getProfondeur() {
		return profondeur;
	}
	public void setProfondeur(int profondeur) {
		if(15<=profondeur&&profondeur<=25) {
			this.profondeur = profondeur;
			this.getTas().setElements(this.largeur, profondeur);
		}
		else{
			throw new IllegalArgumentException("les tailles ne sont pas bonne, veillez réessayer");
		}

	}
	@Override
	public String toString() {
		String message = "";
		message += this.getClass().getSimpleName()+" : Dimension "+largeur+" x "+profondeur;
		message +="\nPiece Actuelle : ";
		if(pieceActuelle!=null) {
			message +=pieceActuelle.toString();
		}else {
			message +="<aucune>\n";
			
		}
		message += "Piece Suivante : ";
		if(pieceSuivante!=null) {
			message +=pieceSuivante.toString();
			
		}else {
			message +="<aucune>\n";
			
		}
		return message;
	}
	
	public void addPropertyChangeListener(PropertyChangeListener listener) {
		pcs.addPropertyChangeListener(listener);
	}
	public void removePropertyChangeListener(PropertyChangeListener listener) {
		pcs.removePropertyChangeListener(listener);
	}
	public Tas getTas() {
		return tas;
	}
    private void gererCollision() {
        this.tas.ajouterElements(pieceActuelle);
        this.tas.verifierEtSupprimerLignesCompletes(); // Vérifier et nettoyer les lignes complètes après chaque collision
        this.setPieceSuivante(UsineDePiece.genererPiece());
    }
	public void gravite(){
		try {
			this.pieceActuelle.deplacerDe(0,1);
		}catch(BloxException e){
			gererCollision();
		}
		
		
	}
    public void incrementerScore(int points) {
        score += points;
        pcs.firePropertyChange("score", null, score);  // Notifie les observateurs du changement de score
    }
    public int getScore() {
        return score;
    }
}

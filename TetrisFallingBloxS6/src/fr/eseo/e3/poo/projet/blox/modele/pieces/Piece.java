package fr.eseo.e3.poo.projet.blox.modele.pieces;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import fr.eseo.e3.poo.projet.blox.modele.BloxException;
import fr.eseo.e3.poo.projet.blox.modele.Coordonnees;
import fr.eseo.e3.poo.projet.blox.modele.Couleur;
import fr.eseo.e3.poo.projet.blox.modele.Element;
import fr.eseo.e3.poo.projet.blox.modele.Puits;

public abstract class Piece {
	private Puits puit;
	private List<Element> elements;
    private int width = 4; // Largeur maximale standard pour les pièces de Tetris dans une grille 4x4
    private int height = 4;
	private Couleur couleur; 
    public Piece(Coordonnees coords, Couleur couleur) {
        this.elements = new ArrayList<>();
        this.couleur = couleur; // Initialisation de la couleur
        this.setElements(coords, couleur);
    }

    public Couleur getCouleur() {
        return couleur;
    }

    abstract protected void setElements(Coordonnees coords, Couleur couleur);
    
    public List<Element> getElements() {
        return elements;
    }

    public Puits getPuits() {
        return puit;
    }

    public void setPuits(Puits puits) {
        this.puit = puits;
    }

    public void setPosition(int abcisse, int ordonne) {
        this.setElements(new Coordonnees(abcisse, ordonne), couleur);
    }
	
	public void deplacerDe(int deltaX, int deltaY) throws BloxException, IllegalArgumentException {
		boolean deplacement=true;
		if (deltaX<-1) {
			deltaX=-1;
		}else if(deltaX>1){
			deltaX=1;
		}
		if((deltaY==1||deltaY==0)) {
			for(int i = 0; i<this.getElements().size(); i++) 
				{
					deplacement=verificationDeplacement(deltaX, deltaY, i);
				}	
					
		}else {
			throw new IllegalArgumentException("les coordonne ne sont pas bonne ne sont pas bonne, veillez réessayer");
		}
		
	if(deplacement) 
				{
					for(int i = 0; i<getElements().size(); i++)
					{
						this.getElements().get(i).deplacerDe(deltaX, deltaY);
					}
				}
	}
	
	
private Boolean verificationDeplacement(int deltaX, int deltaY, int i) throws BloxException {
	boolean deplacement =true;
	if(this.getElements().get(i).getCoordonnees().getAbscisse() + deltaX>this.puit.getLargeur()-1
			||this.getElements().get(i).getCoordonnees().getAbscisse() + deltaX<0) 
	{
		deplacement=false;
		throw new BloxException("tu as touche un cote",BloxException.BLOX_SORTIE_PUITS);		
	}
	if(this.getElements().get(i).getCoordonnees().getOrdonnee() + deltaY<this.puit.getProfondeur()&&
			this.getElements().get(i).getCoordonnees().getOrdonnee() + deltaY>=0){
		if(this.getElements().get(i).getCoordonnees().getAbscisse() + deltaX<this.puit.getLargeur()
				&&this.getElements().get(i).getCoordonnees().getAbscisse() + deltaX>-1) {
			if(this.puit.getTas().getElements()[this.getElements().get(i).getCoordonnees().getOrdonnee()
			 + deltaY][this.getElements().get(i).getCoordonnees().getAbscisse() + deltaX]!=null)
			{
				deplacement=false;
				throw new BloxException("tu as touche le tas",BloxException.BLOX_COLLISION);	
		
			}
		}
	}
	if(this.getElements().get(i).getCoordonnees().getOrdonnee() + deltaY>this.puit.getProfondeur()-1) 
	{
		deplacement=false;
		throw new BloxException("tu as touche le tas",BloxException.BLOX_COLLISION);	
	}

	return deplacement;
}
	
	public void tourner(boolean sensHoraire) throws BloxException {
		int newX,newY;
		Coordonnees vecteurOrigine = this.getElements().get(0).getCoordonnees();
		boolean tourner=true;
		for (int i=0; i<getElements().size();i++) {
			try {
			newX= 0;
			newY=0;
			this.getElements().get(i).deplacerDe(-vecteurOrigine.getAbscisse(), -vecteurOrigine.getOrdonnee());
			if(sensHoraire) {
				newX = - this.getElements().get(i).getCoordonnees().getOrdonnee()
						-this.getElements().get(i).getCoordonnees().getAbscisse();
				newY = this.getElements().get(i).getCoordonnees().getAbscisse()
						-this.getElements().get(i).getCoordonnees().getOrdonnee();
			}else {
				newX =  this.getElements().get(i).getCoordonnees().getOrdonnee()
						-this.getElements().get(i).getCoordonnees().getAbscisse();
				newY = - this.getElements().get(i).getCoordonnees().getAbscisse()
						-this.getElements().get(i).getCoordonnees().getOrdonnee();
			}
			if(this.getElements().get(i).getCoordonnees().getOrdonnee()+vecteurOrigine.getOrdonnee()+newY<0
				|| this.getElements().get(i).getCoordonnees().getAbscisse()+vecteurOrigine.getAbscisse()+newX>this.puit.getLargeur()-1
				||this.getElements().get(i).getCoordonnees().getAbscisse()+vecteurOrigine.getAbscisse()+newX<0) 
			{
				tourner=false;
				throw new BloxException("tu as touche un cote",BloxException.BLOX_SORTIE_PUITS);
						
			}
			else if(this.getElements().get(i).getCoordonnees().getOrdonnee()+vecteurOrigine.getOrdonnee()+newY<this.puit.getProfondeur()
				&&this.getElements().get(i).getCoordonnees().getOrdonnee()+vecteurOrigine.getOrdonnee()+newY>=0)
			{
				if(this.getElements().get(i).getCoordonnees().getAbscisse()+vecteurOrigine.getAbscisse()+newX<this.puit.getLargeur()
					&&this.getElements().get(i).getCoordonnees().getAbscisse()+vecteurOrigine.getAbscisse()+newX>=0)
				{
					if(this.puit.getTas().getElements()
						[this.getElements().get(i).getCoordonnees().getOrdonnee()+vecteurOrigine.getOrdonnee()+newY]
						[this.getElements().get(i).getCoordonnees().getAbscisse()+vecteurOrigine.getAbscisse()+newX]!=null) 
					{
						tourner=false;
						throw new BloxException("tu as touche le tas",BloxException.BLOX_COLLISION);	
					}
				}
			}
			if(this.getElements().get(i).getCoordonnees().getOrdonnee()+vecteurOrigine.getOrdonnee()+newY>
				this.puit.getProfondeur()-1) {
				tourner=false;
				throw new BloxException("tu as touche le tas",BloxException.BLOX_COLLISION);	
			}
				
			
			}catch(BloxException er) {	
		}
		this.getElements().get(i).deplacerDe(vecteurOrigine.getAbscisse(), vecteurOrigine.getOrdonnee());
		}
		
		if(tourner)
		{
			for (int i=0; i<getElements().size();i++)
			{
				this.getElements().get(i).deplacerDe(-vecteurOrigine.getAbscisse(), -vecteurOrigine.getOrdonnee());
				if(sensHoraire)
				{
					newX = - this.getElements().get(i).getCoordonnees().getOrdonnee()
							-this.getElements().get(i).getCoordonnees().getAbscisse();
					newY = this.getElements().get(i).getCoordonnees().getAbscisse()
							-this.getElements().get(i).getCoordonnees().getOrdonnee();
				}
				else
				{
					newX =  this.getElements().get(i).getCoordonnees().getOrdonnee()
							-this.getElements().get(i).getCoordonnees().getAbscisse();
					newY = - this.getElements().get(i).getCoordonnees().getAbscisse()
							-this.getElements().get(i).getCoordonnees().getOrdonnee();
				}
				this.getElements().get(i).deplacerDe(newX,newY);
				this.getElements().get(i).deplacerDe(vecteurOrigine.getAbscisse(), vecteurOrigine.getOrdonnee());
			}
		}
	}
	
	
	
	
	
	
	
    public String toString() {
        return "Piece{" +
               "couleur=" + couleur +
               ", elements=" + elements +
               '}';
    }
	
	@Override
	public int hashCode() {
		return Objects.hash(elements, puit);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Piece other = (Piece) obj;
		return Objects.equals(elements, other.elements);
	}
    public boolean[][] getShape() {
        boolean[][] shape = new boolean[height][width];
        for (Element element : elements) {
            if (element.getCoordonnees().getAbscisse() < width && element.getCoordonnees().getOrdonnee() < height) {
                shape[element.getCoordonnees().getOrdonnee()][element.getCoordonnees().getAbscisse()] = true;
            }
        }
        return shape;
    }
    public Piece(Couleur couleur) {
        this.couleur = couleur;
    }

    // Méthode pour obtenir la couleur pour l'affichage
    public Color getCouleurPourAffichage() {
        return couleur.getCouleurPourAffichage();
    }
}

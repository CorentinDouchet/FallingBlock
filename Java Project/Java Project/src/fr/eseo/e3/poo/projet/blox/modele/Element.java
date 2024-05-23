/**
 * 
 */
package fr.eseo.e3.poo.projet.blox.modele;

import java.util.Objects;

public class Element {
	
	public static final Couleur COULEUR_PAR_DEFAUT=Couleur.ROUGE;
	public static final Coordonnees COORDONNEES_PAR_DEFAUT=new Coordonnees(0, 0);
	private Couleur couleur;
	private Coordonnees coordonnees;
public Element(Coordonnees coordonnees) {
	this(new Coordonnees(coordonnees.getAbscisse(),coordonnees.getOrdonnee()),COULEUR_PAR_DEFAUT);
}
public Element( Coordonnees coordonnees,Couleur couleur) {
	this.coordonnees= coordonnees;
	this.couleur = couleur;
	}

	public Element(int abscisse,int ordonnee){
		this(abscisse,ordonnee,COULEUR_PAR_DEFAUT);
	}
	public Element(int abscisse,int ordonnee,Couleur couleur) {
		this(new Coordonnees(abscisse,ordonnee),couleur);
		
	}
	public Couleur getCouleur() {
		return couleur;
	}
	public void setCouleur(Couleur couleur) {
		this.couleur = couleur;
	}
	public Coordonnees getCoordonnees() {
		return coordonnees;
	}
	public void setCoordonnees(Coordonnees coordonnees) {
		this.coordonnees = coordonnees;
	}
	public void deplacerDe(int deltax, int deltay) {
		this.coordonnees.deplacerDe(deltax,deltay);
	}

	@Override
	public String toString() {
		return coordonnees.toString() + " - " + couleur.name() ;
	}
	@Override
	public int hashCode() {
		return Objects.hash(coordonnees, couleur);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Element other = (Element) obj;
		return Objects.equals(coordonnees, other.coordonnees) && couleur == other.couleur;
	}
	

}

package fr.eseo.e3.poo.projet.blox.modele;

import java.util.Objects;
//composent une piece d'élement carré
public class Element {
	private static final Couleur[] DEFAULT_COULEUR = Couleur.values();
	private Couleur couleur;
	private Coordonnees coordonnees;
	public Element(Coordonnees coordonnees) {
		this(coordonnees,DEFAULT_COULEUR[0]);
	}
	public Element(int abscisse, int ordonnee) {
		this(new Coordonnees(abscisse, ordonnee),DEFAULT_COULEUR[0]);
	}
	public Element(Coordonnees coordonnees,Couleur couleur) {
		this.coordonnees=coordonnees;
		this.couleur=couleur;
	}
	public Element(int abscisse, int ordonnee, Couleur couleur) {
		this(new Coordonnees(abscisse, ordonnee),couleur);
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
	public void deplacerDe(int deltaX, int deltaY) {
		this.setCoordonnees(new Coordonnees(this.getCoordonnees().getAbscisse() + deltaX,
				this.getCoordonnees().getOrdonnee() + deltaY));
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
	@Override
	public String toString() {
		return "("+this.coordonnees.getAbscisse()+", "+this.coordonnees.getOrdonnee()+") - "+this.couleur.toString();
	}
	@Override
	public int hashCode() {
		return Objects.hash(coordonnees, couleur);
	}
	
}

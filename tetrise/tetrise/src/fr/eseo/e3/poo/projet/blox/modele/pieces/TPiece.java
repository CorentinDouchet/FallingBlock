package fr.eseo.e3.poo.projet.blox.modele.pieces;

import fr.eseo.e3.poo.projet.blox.modele.Coordonnees;
import fr.eseo.e3.poo.projet.blox.modele.Couleur;
import fr.eseo.e3.poo.projet.blox.modele.Element;

public class TPiece extends Piece{
	public TPiece(Coordonnees coords, Couleur couleur) {
		super(coords, couleur);
	}
	protected void setElements(Coordonnees coords, Couleur couleur) {
		this.getElements().clear();
		this.getElements().add(new Element(coords.getAbscisse(),coords.getOrdonnee(), couleur));
		this.getElements().add(new Element(coords.getAbscisse()+1,coords.getOrdonnee(), couleur));
		this.getElements().add(new Element(coords.getAbscisse(),coords.getOrdonnee()+1, couleur));
		this.getElements().add(new Element(coords.getAbscisse()-1,coords.getOrdonnee(), couleur));
	}
}

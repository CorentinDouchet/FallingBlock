package modele.pieces;

import modele.Coordonnees;
import modele.Couleur;
import modele.Element;

import java.util.List;
import java.util.ArrayList;

public class IPiece extends Piece {

    public IPiece(Coordonnees coordonnees, Couleur couleur) {
        super(coordonnees, couleur);
    }

    @Override
    protected void setElements(Coordonnees coordonnees, Couleur couleur) {
        elements.add(new Element(new Coordonnees(coordonnees.getAbscisse(), coordonnees.getOrdonnee() - 1), couleur));
        elements.add(new Element(coordonnees, couleur)); // Élément de référence
        elements.add(new Element(new Coordonnees(coordonnees.getAbscisse(), coordonnees.getOrdonnee() + 1), couleur));
        elements.add(new Element(new Coordonnees(coordonnees.getAbscisse(), coordonnees.getOrdonnee() + 2), couleur));
    }

	@Override
	public Object getCouleur() {
		// TODO Auto-generated method stub
		return null;
	}
}

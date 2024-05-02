package modele.pieces;

import modele.Coordonnees;
import modele.Couleur;
import modele.Element;

import java.util.List;
import java.util.ArrayList;

public abstract class Piece {
    protected List<Element> elements;
    protected Coordonnees reference;
    protected Couleur couleur;

    public Piece(Coordonnees coordonnees, Couleur couleur) {
        this.reference = coordonnees;
        this.couleur = couleur;
        this.elements = new ArrayList<>();
        setElements(coordonnees, couleur);
    }

    protected abstract void setElements(Coordonnees coordonnees, Couleur couleur);

    public List<Element> getElements() {
        return elements;
    }

    public void setPosition(int abscisse, int ordonnee) {
        Coordonnees newReference = new Coordonnees(abscisse, ordonnee);
        for (Element element : elements) {
            int dx = element.getCoordonnees().getAbscisse() - this.reference.getAbscisse();
            int dy = element.getCoordonnees().getOrdonnee() - this.reference.getOrdonnee();
            element.setCoordonnees(new Coordonnees(abscisse + dx, ordonnee + dy));
        }
        this.reference = newReference;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName()).append(" :\n");
        for (Element el : elements) {
            sb.append("\t").append(el.toString()).append("\n");
        }
        return sb.toString();
    }

	public abstract Object getCouleur();
}

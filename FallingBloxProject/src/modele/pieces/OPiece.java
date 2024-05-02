package modele.pieces;

import modele.Coordonnees;
import modele.Couleur;
import modele.Element;

import java.util.ArrayList;
import java.util.List;

public class OPiece {
    private List<Element> elements;

    public OPiece(Coordonnees coordonnees, Couleur couleur) {
        this.elements = new ArrayList<>();
        setElements(coordonnees, couleur);
    }

    protected void setElements(Coordonnees coordonnees, Couleur couleur) {
        elements.add(new Element(coordonnees, couleur)); // Element de référence
        elements.add(new Element(new Coordonnees(coordonnees.getAbscisse() + 1, coordonnees.getOrdonnee()), couleur));
        elements.add(new Element(new Coordonnees(coordonnees.getAbscisse(), coordonnees.getOrdonnee() + 1), couleur));
        elements.add(new Element(new Coordonnees(coordonnees.getAbscisse() + 1, coordonnees.getOrdonnee() + 1), couleur));
    }

    public List<Element> getElements() {
        return elements;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("OPiece :\n");
        for (Element element : elements) {
            sb.append("\t").append(element.toString()).append("\n");
        }
        return sb.toString();
    }
}


package modele;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ElementTest {
    private Element element;
    private Coordonnees coordonnees;
    private final Couleur couleur = Couleur.CYAN;

    @BeforeEach
    public void setUp() {
        coordonnees = new Coordonnees(10, 20);
        element = new Element(coordonnees, couleur);
    }

    @Test
    public void testConstructorAndAttributes() {
        assertSame(coordonnees, element.getCoordonnees(), "Les coordonnées devraient être les mêmes que celles passées au constructeur.");
        assertSame(couleur, element.getCouleur(), "La couleur devrait être la même que celle passée au constructeur.");
    }

    @Test
    public void testSetCoordonnees() {
        Coordonnees newCoord = new Coordonnees(5, 15);
        element.setCoordonnees(newCoord);
        assertSame(newCoord, element.getCoordonnees(), "Les coordonnées devraient avoir été mises à jour.");
    }

    @Test
    public void testSetCouleur() {
        element.setCouleur(Couleur.ROUGE);
        assertSame(Couleur.ROUGE, element.getCouleur(), "La couleur devrait avoir été mise à jour.");
    }

    @Test
    public void testToString() {
        String expected = "(10, 20) - CYAN";
        assertEquals(expected, element.toString(), "La sortie de toString ne correspond pas au format attendu.");
    }

    @Test
    public void testEquals() {
        Element sameElement = new Element(new Coordonnees(10, 20), Couleur.CYAN);
        Element differentElement = new Element(new Coordonnees(5, 5), Couleur.ROUGE);

        assertTrue(element.equals(sameElement), "Les deux éléments devraient être considérés comme égaux.");
        assertFalse(element.equals(differentElement), "Les deux éléments ne devraient pas être considérés comme égaux.");
    }

    @Test
    public void testHashCode() {
        Element sameElement = new Element(new Coordonnees(10, 20), Couleur.CYAN);
        assertEquals(element.hashCode(), sameElement.hashCode(), "Les hashcodes devraient être identiques pour deux objets égaux.");
    }
}

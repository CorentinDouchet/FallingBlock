package fr.eseo.e3.poo.projet.blox.modele;



import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class ElementTest {

	@Test
	void testElement() throws Exception{
		Element element = new Element(8,5);
		Element element1 = new Element(new Coordonnees(9, 8));
		Element element2 = new Element(new Coordonnees(7, 6), Couleur.CYAN);
		Element element3 = new Element(2,3, Couleur.BLEU);
		assertEquals("(8, 5) - ROUGE", element.toString());
		assertEquals("(9, 8) - ROUGE", element1.toString());
		assertEquals("(2, 3) - BLEU", element3.toString());
		assertEquals("(7, 6) - CYAN", element2.toString());
		assertEquals(Couleur.ROUGE, element.getCouleur());
		assertEquals(new Coordonnees(8, 5), element.getCoordonnees());
		element.setCoordonnees(new Coordonnees(10,10));
		element.setCouleur(Couleur.VERT);
		assertEquals("(10, 10) - VERT", element.toString());
		assertTrue(element.equals(element));
		assertFalse(element.equals(null));
		assertFalse(element.equals(new Coordonnees(0, 0)));
		assertFalse(element.equals(element1));
		assertFalse(element.equals(new Element(new Coordonnees(10, 10))));
		assertTrue(element.equals(new Element(new Coordonnees(10, 10), Couleur.VERT)));
		assertFalse(element.equals(new Element(new Coordonnees(4, 10), Couleur.ROUGE)));
		element.deplacerDe(1, 0);
		assertEquals(new Element(new Coordonnees(11, 10), Couleur.VERT), element);
		element.deplacerDe(-1, 0);
		assertEquals(new Element(new Coordonnees(10, 10), Couleur.VERT), element);
		element.deplacerDe(0, 1);
		assertEquals(new Element(new Coordonnees(10, 11), Couleur.VERT), element);
	}
}

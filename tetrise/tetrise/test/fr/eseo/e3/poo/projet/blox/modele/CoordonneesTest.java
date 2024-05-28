package fr.eseo.e3.poo.projet.blox.modele;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class CoordonneesTest {
	@Test
	public void testCoordonne() {
		Coordonnees coord = new Coordonnees(0, 0);
		assertEquals(0, coord.getAbscisse(),"tstring");
		assertEquals(0, coord.getOrdonnee(),"totring");
		coord.setOrdonnee(5);
		coord.setAbscisse(1);
		assertEquals(5, coord.getOrdonnee(),"totring");
		assertEquals(1, coord.getAbscisse(),"tstring");
		assertEquals("(1, 5)", coord.toString(),"tostring");
		assertEquals(997,coord.hashCode(),"h");
		assertTrue(coord.equals(coord));
		assertFalse(coord.equals(null));
		assertFalse(coord.equals(new Element(new Coordonnees(0, 0))));
		assertFalse(coord.equals(new Coordonnees(1, 8)));
		assertFalse(coord.equals(new Coordonnees(2, 6)));
		assertTrue(coord.equals(new Coordonnees(1, 5)));
		assertFalse(coord.equals(new Coordonnees(5, 5)));
	}
	

}

/**
 * 
 */
package fr.eseo.e3.poo.projet.blox.modele;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class CoordonneesTest {

	@Test
	public void testConstructeursAccesseurs() {
		Coordonnees c=new Coordonnees(2, 3);
		assertEquals(2,c.getAbscisse(),"abscisse correcte");
		assertEquals(3,c.getOrdonnee(),"ordonnee correcte");
		c.setAbscisse(1);
		c.setOrdonnee(0);
		assertEquals(1,c.getAbscisse(),"abscisse modifiée");
		assertEquals(0,c.getOrdonnee(),"ordonnee modifiée");
		
	}
	@Test
	public void testtoString() {
		Coordonnees c=new Coordonnees(7, 3);
		assertEquals("(7, 3)",c.toString(),"représentation textuelle OK");
	}
	

}

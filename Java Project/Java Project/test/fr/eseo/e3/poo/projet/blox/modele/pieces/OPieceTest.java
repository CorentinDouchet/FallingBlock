/**
 * 
 */
package fr.eseo.e3.poo.projet.blox.modele.pieces;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import fr.eseo.e3.poo.projet.blox.modele.BloxException;
import fr.eseo.e3.poo.projet.blox.modele.Coordonnees;
import fr.eseo.e3.poo.projet.blox.modele.Couleur;
import fr.eseo.e3.poo.projet.blox.modele.Element;
import fr.eseo.e3.poo.projet.blox.modele.Puits;

public class OPieceTest {
	private static Coordonnees c;
	private static Couleur couleur;
	@BeforeAll
	public static void setUp() {
		c=new Coordonnees(1, 2);	
		couleur=Couleur.ORANGE;
	}
	 
	@Test
	public void testConstructeursAccesseurs() {
		OPiece o=new OPiece(c, couleur);
		ArrayList<Element>elements = new ArrayList<>();
		elements.add(new Element(new Coordonnees(1,2),Couleur.ORANGE));
		elements.add(new Element(new Coordonnees(2,1),Couleur.ORANGE));
		elements.add(new Element(new Coordonnees(1,1),Couleur.ORANGE));
		elements.add(new Element(new Coordonnees(2,2),Couleur.ORANGE));
		
		assertEquals(elements,o.getElements(),"Liste OK");
		
		
		
		/*o.setElements(c, couleur);
		
		assertEquals(elements.get(0),o.getElements().get(0),"Liste OK");
		assertEquals(elements.get(1),o.getElements().get(1),"Liste OK");
		assertEquals(elements.get(2),o.getElements().get(2),"Liste OK");
		assertEquals(elements.get(3),o.getElements().get(3),"Liste OK");*/
		}
	

	 

	    @Test
	    public void testDeplacerDe() {
	     OPiece o=new OPiece(c, couleur);	
	     o.setPosition(11,12);
		try {
			o.deplacerDe(1, 0);
		} catch (BloxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals("OPiece :\n\t(12, 12) - ORANGE\n\t(13, 11) - ORANGE\n\t(12, 11) - ORANGE\n\t(13, 12) - ORANGE\n",o.toString(),"Error");

		 assertThrows(IllegalArgumentException.class, () -> o.deplacerDe(4, -1));
		
		
	    }	
	    @Test
		void testTourner(){
			OPiece opiece = new OPiece(c,couleur);
			opiece.setPosition(12,13);
			opiece.tourner(true);
			assertEquals("OPiece :\n\t(12, 13) - ORANGE\n\t(13, 12) - ORANGE\n\t(12, 12) - ORANGE\n\t(13, 13) - ORANGE\n",opiece.toString(),"Error");
		}
	
	@Test
	public void testtoString() {
		Coordonnees c=new Coordonnees(3, 1);
		Couleur couleur=Couleur.ORANGE;
		OPiece o= new OPiece(c, couleur);
		assertEquals("OPiece :\n"	+
				"\t(3, 1) - ORANGE\n" +
				"\t(4, 0) - ORANGE\n" +
				"\t(3, 0) - ORANGE\n" +
				"\t(4, 1) - ORANGE\n" ,o.toString(),"représentation textuelle OK");
			
	}
	@Test
	public void testPuits() {
		Puits p=new Puits(10,16);
		OPiece o= new OPiece(new Coordonnees(1, 0),Couleur.CYAN);
		o.setPuits(p);
		assertEquals(p, o.getPuits(), "OK");
	}
}

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

public class IPieceTest {
	private static Coordonnees c;
	private static Couleur couleur;
	@BeforeAll
	public static void setUp() {
		c=new Coordonnees(1, 2);	
		couleur=Couleur.ORANGE;
	}

	@Test
	 public void testConstructeursAccesseurs() {
		
			IPiece i= new IPiece(c, couleur);
			

			ArrayList<Element>elements = new ArrayList<>();
			elements.add(new Element(new Coordonnees(1,2),Couleur.ORANGE));
			elements.add(new Element(new Coordonnees(1,1),Couleur.ORANGE));
			elements.add(new Element(new Coordonnees(1,0),Couleur.ORANGE));
			elements.add(new Element(new Coordonnees(1,3),Couleur.ORANGE));
			
			assertEquals(elements,i.getElements(),"Liste OK");
	}
	@Test
	public void testPuits() {
		Puits p=new Puits(10,16);
		IPiece i= new IPiece(new Coordonnees(1, 0),Couleur.CYAN);
		i.setPuits(p);
		assertEquals(p, i.getPuits(), "OK");
	}


@Test
public void testDeplacerDe() {
	IPiece i=new IPiece(c, couleur);	
   i.setPosition(11,12);
   try {
	i.deplacerDe(1, 0);
} catch (BloxException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
   assertEquals("IPiece :\n\t(12, 12) - ORANGE\n\t(12, 11) - ORANGE\n\t(12, 10) - ORANGE\n\t(12, 13) - ORANGE\n",i.toString(),"Error");

    assertThrows(IllegalArgumentException.class, () -> i.deplacerDe(4, -1));


}
@Test
void testTourner(){
	IPiece ipiece = new IPiece(c,couleur);
	ipiece.setPosition(12,13);
	try {
		ipiece.tourner(true);
	} catch (BloxException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	assertEquals("IPiece :\n\t(12, 13) - ORANGE\n\t(13, 13) - ORANGE\n\t(14, 13) - ORANGE\n\t(11, 13) - ORANGE\n",ipiece.toString(),"Error");
}
}

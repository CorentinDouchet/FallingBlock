/**
 * 
 */
package fr.eseo.e3.poo.projet.blox.modele;




import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class ElementTest {

	@Test
	public void testConstructeursAccesseurs() {
		Coordonnees c=new Coordonnees(2, 3);
		Couleur couleur=Couleur.BLEU;
		Element e=new Element(c);
		Element e1=new Element(c, couleur);
		Element e0=new Element(5, 7);
		Element e2=new Element( 8, 9,couleur);
		assertEquals(Couleur.ROUGE,e.getCouleur(),"Couleur OK");
		assertEquals(c,e.getCoordonnees(),"Coordonnees OK");
		
		assertEquals(couleur,e1.getCouleur(),"Couleur Ok");
		assertEquals(c,e1.getCoordonnees(),"Coordonnees OK");
		
		assertEquals(Couleur.ROUGE,e.getCouleur(),"Couleur OK");
		assertEquals(5,e0.getCoordonnees().getAbscisse(),"abscisse OK");
		assertEquals(7,e0.getCoordonnees().getOrdonnee(),"ordonnee OK");
		
		assertEquals(couleur,e2.getCouleur(),"Couleur Ok");
		assertEquals(8,e2.getCoordonnees().getAbscisse(),"abscisse OK");
		assertEquals(9,e2.getCoordonnees().getOrdonnee(),"ordonnee OK");
		//Test accesseurs
		e1.setCoordonnees(new Coordonnees(4, 0));
		e1.setCouleur(Couleur.CYAN);
		assertEquals(Couleur.CYAN,e1.getCouleur(),"Couleur modifiée");
		assertEquals(new Coordonnees(4, 0),e1.getCoordonnees(),"Coordonnees modifiées");
		
	}
	@Test
	public void testtoString() {
		Element e1=new Element( new Coordonnees(12, 7),Couleur.VIOLET);
		assertEquals("(12, 7) - VIOLET",e1.toString(),"");
	}
	@Test
	public void testDeplacerde() {
		Element e=new Element(2, 5) ;
		e.deplacerDe(4, 7);
		
		assertEquals(6,e.getCoordonnees().getAbscisse(),"OK");
		assertEquals(12,e.getCoordonnees().getOrdonnee(),"OK");
		
	}
	
		
	}



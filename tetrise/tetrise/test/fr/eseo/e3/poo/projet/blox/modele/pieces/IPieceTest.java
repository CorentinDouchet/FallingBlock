package fr.eseo.e3.poo.projet.blox.modele.pieces;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import fr.eseo.e3.poo.projet.blox.modele.BloxException;
import fr.eseo.e3.poo.projet.blox.modele.Coordonnees;
import fr.eseo.e3.poo.projet.blox.modele.Couleur;
import fr.eseo.e3.poo.projet.blox.modele.Element;
import fr.eseo.e3.poo.projet.blox.modele.Puits;

public class IPieceTest {
	 private Piece piece;
	@Test
	void test() {
		IPiece piece1= new IPiece(new Coordonnees(0,0),Couleur.CYAN);
		assertEquals("IPiece :\n	(0, 0) - CYAN\n	(0, 1) - CYAN\n	(0, -1) - CYAN\n	(0, -2) - CYAN\n",piece1.toString());
		assertEquals(new IPiece(new Coordonnees(0,0),Couleur.CYAN),piece1);
		
		
	}
    @Test
    public void testGetElements() {
    	 piece = new IPiece(new Coordonnees(0, 0), Couleur.ROUGE);
        assertNotNull(piece.getElements());
    }

    @Test
    public void testGetPuits() {
    	 piece = new IPiece(new Coordonnees(0, 0), Couleur.ROUGE);
        assertNull(piece.getPuits());
    }

    @Test
    public void testSetPuits() {
    	 piece = new IPiece(new Coordonnees(0, 0), Couleur.ROUGE);
        Puits puits = new Puits();
        piece.setPuits(puits);
        assertEquals(puits, piece.getPuits());
    }

    @Test
    public void testSetPosition() {
    	 piece = new IPiece(new Coordonnees(0, 0), Couleur.ROUGE);
        piece.setPosition(2, 3);
        assertEquals(2, piece.getElements().get(0).getCoordonnees().getAbscisse());
        assertEquals(3, piece.getElements().get(0).getCoordonnees().getOrdonnee());
    }

    @Test
    public void testDeplacerDeValid() {
    	 piece = new IPiece(new Coordonnees(3, 4), Couleur.CYAN);
        Puits puits = new Puits(10,20);
        piece.setPuits(puits);
        try {
            piece.deplacerDe(1, 0);
        } catch (BloxException | IllegalArgumentException e) {
            fail("Unexpected exception: " + e.getMessage());
        }
        
        try {
            piece.deplacerDe(-1, 0);
        } catch (BloxException | IllegalArgumentException e) {
            fail("Unexpected exception: " + e.getMessage());
        }
        try {
            piece.deplacerDe(0, 0);
        } catch (BloxException | IllegalArgumentException e) {
            fail("Unexpected exception: " + e.getMessage());
        }
        try {
            piece.deplacerDe(0, 1);
        } catch (BloxException | IllegalArgumentException e) {
            fail("Unexpected exception: " + e.getMessage());
        }
        try {
            piece.deplacerDe(-1, 1);
        } catch (BloxException | IllegalArgumentException e) {
            fail("Unexpected exception: " + e.getMessage());
        }
        try {
            piece.deplacerDe(1, 1);
        } catch (BloxException | IllegalArgumentException e) {
            fail("Unexpected exception: " + e.getMessage());
        }
        piece.setPosition(5, -18);
        try {
        	 piece.deplacerDe(0, 1);
        } catch (BloxException | IllegalArgumentException e) {
            fail("Unexpected exception: " + e.getMessage());
        }
        piece.setPosition(9, 5);
        try {
       	 piece.deplacerDe(-1, 0);
       } catch (BloxException | IllegalArgumentException e) {
           fail("Unexpected exception: " + e.getMessage());
       }
        piece.setPosition(5, 5);
        try {
        	piece.deplacerDe(1, 0);
        	piece.deplacerDe(-1, 0);
        	piece.deplacerDe(50, 0);
        	piece.deplacerDe(-50, 0);
       } catch (BloxException | IllegalArgumentException e) {
           fail("Unexpected exception: " + e.getMessage());
       }


        
    }

    @Test
    public void testDeplacerDeInvalid() {

        
    	 piece = new IPiece(new Coordonnees(0, 10), Couleur.ROUGE);
        Puits puits = new Puits(10,20);
        puits.getTas().getElements()[7][0]=new Element(0,7);
        piece.setPuits(puits);
      
        assertThrows(IllegalArgumentException.class, () -> {
         	 piece.deplacerDe(-2, 2);
        });
        assertThrows(IllegalArgumentException.class, () -> {
         	 piece.deplacerDe(0, -2);
        });
        piece.setPosition(9, 10);
       
        assertThrows(BloxException.class, () -> {
       	 piece.deplacerDe(1, 0);
       });
        piece.setPosition(9, 19);
        assertThrows(BloxException.class, () -> {
       	 piece.deplacerDe(0, 1);
       });
        piece.setPosition(9, 5);
        assertThrows(BloxException.class, () -> {
       	 piece.deplacerDe(1, 0);
       });
        piece.setPosition(0, 5);
        assertThrows(BloxException.class, () -> {
       	 piece.deplacerDe(-1, 0);
       });
        piece.setPosition(0, 5);
        assertThrows(BloxException.class, () -> {
       	 piece.deplacerDe(0, 1);
       });
        piece.setPosition(-5, 5);
        assertThrows(BloxException.class, () -> {
       	 piece.deplacerDe(0, 1);
       });
        piece.setPosition(-5, 5);
        assertThrows(BloxException.class, () -> {
       	 piece.deplacerDe(0, 1);
       });
        piece.setPosition(0, 5);
        assertThrows(BloxException.class, () -> {
       	 piece.deplacerDe(-1, 0);
       });
        piece.setPosition(9, 5);
        assertThrows(BloxException.class, () -> {
       	 piece.deplacerDe(1, 0);
       });
    }

    @Test
    public void testTournerValid() {
    	 piece = new IPiece(new Coordonnees(5, 5), Couleur.ROUGE);
        Puits puits = new Puits(10,20);
        piece.setPuits(puits);
        try {
            piece.tourner(true);
        } catch (BloxException e) {
            fail("Unexpected exception: " + e.getMessage());
        }

        try {
            piece.tourner(false);
        } catch (BloxException e) {
            fail("Unexpected exception: " + e.getMessage());
        }

        
    }
    

   
    @Test
    public void testToString() {
    	 piece = new IPiece(new Coordonnees(0, 0), Couleur.ROUGE);
    	 assertEquals("IPiece :\n	(0, 0) - ROUGE\n	(0, 1) - ROUGE\n	(0, -1) - ROUGE\n	(0, -2) - ROUGE\n",piece.toString());
       
    }
    @Test
    public void testEquals() {
    	
    	Piece piece1 = new IPiece(new Coordonnees(0, 0), Couleur.ROUGE);
    	piece1.hashCode();
    	
    	assertTrue(piece1.equals(piece1));
        assertFalse(piece1.equals(null));
        assertFalse(piece1.equals(new OPiece(new Coordonnees(0,0), Couleur.ROUGE)));
        Piece piece2 = new IPiece(new Coordonnees(0,0), Couleur.ROUGE);
        Piece piece3 = new IPiece(new Coordonnees(0,5), Couleur.ROUGE);
        assertTrue(piece1.equals(piece2));
        assertFalse(piece1.equals(piece3));
        
    }

}

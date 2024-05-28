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

public class OPieceTest {
	OPiece piece=new OPiece(new Coordonnees(0,0),Couleur.CYAN);
	@Test
	void test() {
		assertEquals("OPiece :\n	(0, 0) - CYAN\n	(1, 0) - CYAN\n	(0, -1) - CYAN\n	(1, -1) - CYAN\n",piece.toString());
		assertEquals(new OPiece(new Coordonnees(0,0),Couleur.CYAN),piece);
		piece.setPosition(8, 8);
		assertEquals(new OPiece(new Coordonnees(8,8),Couleur.CYAN),piece);
		piece.setPuits(new Puits());
		assertEquals(new Puits().toString(), piece.getPuits().toString());
		assertTrue(piece.equals(piece));
		assertFalse(piece.equals(null));
		assertFalse(piece.equals(new IPiece(new Coordonnees(9, 8), Couleur.CYAN)));
		piece.tourner(false);
		piece.hashCode();
		
	}
    @Test
    public void testSetPosition() {
    	 piece = new OPiece(new Coordonnees(0, 0), Couleur.ROUGE);
        piece.setPosition(2, 3);
        assertEquals(2, piece.getElements().get(0).getCoordonnees().getAbscisse());
        assertEquals(3, piece.getElements().get(0).getCoordonnees().getOrdonnee());
    }
    @Test
    public void testGetElements() {
    	 piece = new OPiece(new Coordonnees(0, 0), Couleur.ROUGE);
        assertNotNull(piece.getElements());
    }

    @Test
    public void testGetPuits() {
    	 piece = new OPiece(new Coordonnees(0, 0), Couleur.ROUGE);
        assertNull(piece.getPuits());
    }

    @Test
    public void testSetPuits() {
    	 piece = new OPiece(new Coordonnees(0, 0), Couleur.ROUGE);
        Puits puits = new Puits();
        piece.setPuits(puits);
        assertEquals(puits, piece.getPuits());
    }


    @Test
    public void testDeplacerDeValid() {
    	 piece = new OPiece(new Coordonnees(3, 4), Couleur.CYAN);
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
        piece.setPosition(9, 6);
        try {
       	 piece.deplacerDe(-1, 0);
       } catch (BloxException | IllegalArgumentException e) {
           fail("Unexpected exception: " + e.getMessage());
       }
        piece.setPosition(5, 6);
        try {
        	piece.deplacerDe(1, 0);
        	piece.deplacerDe(-1, 0);
        	piece.deplacerDe(2, 0);

       } catch (BloxException | IllegalArgumentException e) {
           fail("Unexpected exception: " + e.getMessage());
       }

        
    }
    @Test
    public void testDeplacerDeInvalid() {
        Puits puits = new Puits(10,20);
        puits.getTas().getElements()[7][0]=new Element(0,7);
        piece.setPuits(puits);
        assertThrows(BloxException.class, () -> {
        	 piece.deplacerDe(-1, 0);
        });
       
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
        piece.setPosition(9, 6);
        assertThrows(BloxException.class, () -> {
       	 piece.deplacerDe(1, 0);
       });
        piece.setPosition(0, 6);
        assertThrows(BloxException.class, () -> {
       	 piece.deplacerDe(-1, 0);
       });
       piece.setPosition(0, 6);
        assertThrows(BloxException.class, () -> {
       	 piece.deplacerDe(0, 1);
       });
        piece.setPosition(-5, 6);
        assertThrows(BloxException.class, () -> {
       	 piece.deplacerDe(0, 1);
       });

    }

    @Test
    public void testTournerValid() {
        Puits puits = new Puits(10,20);
        piece.setPuits(puits);
        piece.tourner(false);
        piece.tourner(true);        
    }

}
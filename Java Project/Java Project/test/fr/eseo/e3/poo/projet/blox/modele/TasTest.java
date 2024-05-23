/**
 * 
 */
package fr.eseo.e3.poo.projet.blox.modele;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TasTest {

	private Tas tas;
    private Puits puits;
    private Element[][] elements;
    private int nbElements;
    private int nbLignes;
    
    @BeforeEach
    void setUp() {
        puits = new Puits();
        tas = new Tas(puits);
        elements = tas.getElements();
        nbElements = puits.getLargeur();
        nbLignes = puits.getProfondeur() - 1; 
    }
    
    @Test
    void testConstructeurParDefaut() {
        Element[][] elements = tas.getElements();
        assertEquals(puits.getLargeur(), elements.length);
        assertEquals(puits.getProfondeur() - 1, elements[0].length);  
    }
    
   
    
   
    
    @Test
    void testConstruireTas() {
        //tas.construireTas(nbElements, nbLignes, new java.util.Random());
        Element[][] elements = tas.getElements();
        
        Set<Couleur> couleurs = new HashSet<>();
        for (int i = 0; i < elements.length; i++) {
            for (int j = 0; j < elements[i].length; j++) {
                assertNotNull(elements[i][j]);
                couleurs.add(elements[i][j].getCouleur());
            }
        }
        assertEquals(puits.getLargeur(), couleurs.size()); // vérifie qu'il y a une couleur unique par colonne
    }
    
    @Test
    void testGetPuits() {
        assertEquals(puits, tas.getPuits());
    }
    
    @Test
    void testGetElements() {
        Element[][] elements = tas.getElements();
        assertNotNull(elements);
        assertEquals(puits.getLargeur(), elements.length);
        assertEquals(puits.getProfondeur() -1, elements[0].length); // une ligne est réservée pour la pièce actuelle
    }
    
    /*@Test
    void testIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> new Tas(puits, puits.getLargeur() * puits.getProfondeur()));
    }*/
 
}

package modele;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PuitsTest {
    private Puits puits;

    @BeforeEach
    public void setUp() {
        puits = new Puits();
    }

    @Test
    public void testDefaultConstructor() {
        assertEquals(Puits.LARGEUR_PAR_DEFAUT, puits.getLargeur(), "La largeur par défaut doit être respectée.");
        assertEquals(Puits.PROFONDEUR_PAR_DEFAUT, puits.getProfondeur(), "La profondeur par défaut doit être respectée.");
    }

    @Test
    public void testCustomConstructor() {
        Puits customPuits = new Puits(7, 20);
        assertEquals(7, customPuits.getLargeur(), "La largeur personnalisée doit être respectée.");
        assertEquals(20, customPuits.getProfondeur(), "La profondeur personnalisée doit être respectée.");
    }

    @Test
    public void testSetDimensionsInvalides() {
        assertThrows(IllegalArgumentException.class, () -> puits.setLargeur(4), "Doit lancer une IllegalArgumentException pour une largeur invalide.");
        assertThrows(IllegalArgumentException.class, () -> puits.setProfondeur(30), "Doit lancer une IllegalArgumentException pour une profondeur invalide.");
    }

    @Test
    public void testToString() {
        String expected = "Puits : Dimension 10 x 20\nPiece Actuelle : <aucune>\nPiece Suivante : <aucune>";
        assertEquals(expected, puits.toString(), "Le toString doit retourner la bonne chaîne.");
    }

    // Ajoutez d'autres tests si nécessaire...
}

package modele;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class CoordonneesTest {

    @Test
    void testCoordonneesConstructorAndGetters() {
        Coordonnees coord = new Coordonnees(1, 2);
        assertEquals(1, coord.getAbscisse());
        assertEquals(2, coord.getOrdonnee());
    }

    @Test
    void testCoordonneesToString() {
        Coordonnees coord = new Coordonnees(1, 2);
        String expected = "(1, 2)";
        assertEquals(expected, coord.toString());
    }

    @Test
    void testCoordonneesEquality() {
        Coordonnees coord1 = new Coordonnees(1, 2);
        Coordonnees coord2 = new Coordonnees(1, 2);
        Coordonnees coord3 = new Coordonnees(3, 4);

        assertEquals(coord1, coord2);
        assertNotEquals(coord1, coord3);
    }

    @Test
    void testCoordonneesHashCode() {
        Coordonnees coord1 = new Coordonnees(1, 2);
        Coordonnees coord2 = new Coordonnees(1, 2);

        assertEquals(coord1.hashCode(), coord2.hashCode());
    }
}

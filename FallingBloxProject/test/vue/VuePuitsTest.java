package vue;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import modele.Puits;

public class VuePuitsTest {

    @Test
    public void testVuePuitsInitialization() {
        Puits puits = new Puits(10, 20);
        VuePuits vuePuits = new VuePuits(puits);
        assertEquals(200, vuePuits.getPreferredSize().width);
        assertEquals(400, vuePuits.getPreferredSize().height);
        assertNotNull(vuePuits.getPuits());
    }
}

package fr.eseo.e3.poo.projet.blox.vue;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import fr.eseo.e3.poo.projet.blox.modele.Puits;

public class VuePuitsTest {

	@Test
	void test() {
		Puits puit = new Puits();
		VuePuits vue = new VuePuits(new Puits());
		puit.addPropertyChangeListener(vue);
		assertEquals(new Puits().toString(), vue.getPuits().toString());
		assertEquals(15, vue.getTaille());
		vue.setPuits(new Puits(6,15));
		vue.setTaille(2);
		assertEquals(new Puits(6,15).toString(), vue.getPuits().toString());
		assertEquals(2, vue.getTaille());
		
		assertEquals(null, vue.getVuePiece());
	}

}

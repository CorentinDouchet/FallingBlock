/**
 * 
 */
package fr.eseo.e3.poo.projet.blox.modele.pieces;

import java.util.ArrayList;
import java.util.List;

import fr.eseo.e3.poo.projet.blox.modele.BloxException;
import fr.eseo.e3.poo.projet.blox.modele.Coordonnees;
import fr.eseo.e3.poo.projet.blox.modele.Couleur;
import fr.eseo.e3.poo.projet.blox.modele.Element;
import fr.eseo.e3.poo.projet.blox.modele.Puits;

public abstract class Piece {
	private List<Element> elements;
	private Puits puits;

	public Piece(Coordonnees coordonnees, Couleur couleur) {
		this.elements = new ArrayList<>();
		setElements(coordonnees, couleur);
	}

	public List<Element> getElements() {
		return elements;
	}

	protected abstract void setElements(Coordonnees coordonnees, Couleur couleur);

	public void setPosition(int abscisse, int ordonnee) {

		this.setElements(new Coordonnees(abscisse, ordonnee), getElements().get(0).getCouleur());

	}

	public Puits getPuits() {
		return this.puits;

	}

	public void setPuits(Puits puits) {
		this.puits = puits;
	}

	public void deplacerDe(int deltax, int deltay) throws BloxException {
		if (deltax > 1 || deltay > 1 || deltay < 0) {
			throw new IllegalArgumentException(
					"La pièce ne peut être déplacée que vers la droite, la gauche ou le bas.");
		}

		for (Element e : elements) {
			int newX = e.getCoordonnees().getAbscisse() + deltax;
			int newY = e.getCoordonnees().getOrdonnee() + deltay;
			if (puits != null) {

				if (newX < 0 || newX >= getPuits().getLargeur()) {
					throw new BloxException("Sortie de puits détectée", BloxException.BLOX_SORTIE_PUITS);
				} else if (newY >= getPuits().getProfondeur()) {
					throw new BloxException("Sortie de puits détectée", BloxException.BLOX_COLLISION);
				} else if (newY >= 0 && puits.getTas().getElements()[newY][newX] != null) {
					throw new BloxException("Collision détectée", BloxException.BLOX_COLLISION);
				}
			}
		}

		for (Element e1 : elements) {
			e1.setCoordonnees(new Coordonnees(e1.getCoordonnees().getAbscisse() + deltax,
					e1.getCoordonnees().getOrdonnee() + deltay));

		}
	}

	public void tourner(boolean sensHoraire) throws BloxException {
		Element elemtRef = elements.get(0);
		int x0 = elemtRef.getCoordonnees().getAbscisse();
		int y0 = elemtRef.getCoordonnees().getOrdonnee();
		int[] tabX = new int[this.elements.size()];
		int[] tabY = new int[this.elements.size()];

		for (int i = 0; i < this.elements.size(); i++) {
			int x1 = this.elements.get(i).getCoordonnees().getAbscisse() - x0;
			int y1 = this.elements.get(i).getCoordonnees().getOrdonnee() - y0;
			int newX, newY;
			if (sensHoraire) {
				newX = -y1;
				newY = x1;
			} else {
				newX = y1;
				newY = -x1;
			}
			if (puits != null) {

				if (newX + x0 < 0 || newX + x0 >= getPuits().getLargeur()) {
					throw new BloxException("Sortie de puits détectée", BloxException.BLOX_SORTIE_PUITS);

				} else if (newY + y0 >= getPuits().getProfondeur()) {
					throw new BloxException("Sortie de puits détectée", BloxException.BLOX_COLLISION);
				} else if (newY + y0 >= 0 && puits.getTas().getElements()[newY + y0][newX + x0] != null) {
					throw new BloxException("Collision détectée", BloxException.BLOX_COLLISION);

				}
			}

			tabX[i] = newX + x0;
			tabY[i] = newY + y0;
		}

		for (int i = 0; i < this.elements.size(); i++) {
			this.elements.get(i).setCoordonnees(new Coordonnees(tabX[i], tabY[i]));
		}

	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(this.getClass().getSimpleName());
		sb.append(" :");
		sb.append("\n");
		for (Element e : getElements()) {
			sb.append("\t");
			sb.append(e.toString());
			sb.append("\n");
		}
		return sb.toString();
	}

}

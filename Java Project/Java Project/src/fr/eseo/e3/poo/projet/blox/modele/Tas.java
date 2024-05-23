package fr.eseo.e3.poo.projet.blox.modele;

import java.util.Random;

import fr.eseo.e3.poo.projet.blox.modele.pieces.Piece;

public class Tas {
    private Element[][] elements;
    private Puits puits;
    private int nbElementPlace;

    public Tas(Puits puits) {
        this.puits = puits;
        this.elements = new Element[puits.getProfondeur()][puits.getLargeur()];
        int nbElementPlace = 0;
    }

    public Tas(Puits puits, int nbElements) {
        if (nbElements <= 0 || nbElements > puits.getProfondeur() * puits.getLargeur()) {
            throw new IllegalArgumentException("Le nombre d'éléments doit être compris entre 1 et la taille du puits.");
        }

        this.puits = puits;
        this.elements = new Element[puits.getProfondeur()][puits.getLargeur()];

        Random random = new Random();
        construireTas(nbElements,nbElements/puits.getLargeur()+1 , random);
        int nbElementPlace = 0;
    }


    public Tas(Puits puits, int nbElements, int nbLignes) {
        int tailleMax = puits.getLargeur() * puits.getProfondeur();
        if (nbElements <= 0 || nbElements > tailleMax) {
            throw new IllegalArgumentException("Le nombre d'éléments doit être compris entre 1 et la taille maximale du puits.");
        }
        this.puits = puits;
        this.elements = new Element[this.puits.getProfondeur()][this.puits.getLargeur()];
        construireTas(nbElements, nbLignes, new Random());
    }

    public Puits getPuits() {
        return this.puits;
    }

    public Element[][] getElements() {
        return this.elements;
    }
    public int getNbre() {
    	return nbElementPlace;
    }
    public void ajouterElements(Piece p) {
		for(Element element :p.getElements()) {
			int x=element.getCoordonnees().getAbscisse();
			int y=element.getCoordonnees().getOrdonnee();
			this.elements[y][x]=element;
			
		}
	}

    private void construireTas(int nbElements, int nbLigne, Random rand) {
        int tailleMax = this.puits.getLargeur() * nbLigne;
        if (nbElements != 0 && nbElements >= tailleMax) {
            throw new IllegalArgumentException("Erreur dans la construction du tas");
        }
        int nbElementPlace = 0;
        int ord;
        int abs;
        int indiceCouleur;
        while (nbElementPlace < nbElements) {
            ord = this.getPuits().getProfondeur() - (rand.nextInt(nbLigne)+1);
            abs = rand.nextInt(this.puits.getLargeur());
            if (this.elements[ord][abs] == null) {
                indiceCouleur = rand.nextInt(Couleur.values().length);
                this.elements[ord][abs] = new Element(new Coordonnees(abs, ord), Couleur.values()[indiceCouleur]);
                nbElementPlace++;
            }
        }
    }
}

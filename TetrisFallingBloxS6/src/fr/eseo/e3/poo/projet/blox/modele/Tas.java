package fr.eseo.e3.poo.projet.blox.modele;
//stocke les elements dans dans un tableau
import java.util.Random;

import fr.eseo.e3.poo.projet.blox.modele.pieces.Piece;
public class Tas {
	private Puits puits;
	private Element[][] elements;
	public Tas(Puits puit) {
		this.puits = puit;
		this.elements = new Element[puit.getProfondeur()][puit.getLargeur()];
	}
	public Tas(Puits puit, int nbElements) {
		this(puit,nbElements,(nbElements/(puit.getLargeur())+1));
		}
	public Tas(Puits puit, int nbElements, int nbLignes) {
		this.puits = puit;
		this.elements = new Element[puit.getProfondeur()][puit.getLargeur()];
		construireTas(nbElements, nbLignes, new Random());
	}
	
	public Puits getPuits() {
		return puits;
	}
	public void setElements(int largeur, int profondeur) {
		Element[][] elements2=new Element[profondeur][largeur];
		for (int i=0;i<elements.length;i++) {
			for (int j=0;j<elements[1].length;j++) {
				if(i<profondeur) {
					if(j<largeur) {
						elements2[i][j]=elements[i][j];
					}
				}
			}
		}
		elements=elements2;
	}
	public Element[][] getElements() {
		return elements;
	}
	private void construireTas(int nbElements, int nbLignes, Random rand) {
		if(nbElements !=0 && nbElements>= this.puits.getLargeur()*nbLignes) {
			 throw new IllegalArgumentException("il y a trop d element par rapport au tas");
		}
		
		int nbElementPlace = 0;
		int ordon,absci,randP, indiceCouleur;
		while(nbElementPlace<=nbElements-1) {
			randP =rand.nextInt(nbLignes)+1;
			ordon = this.puits.getProfondeur()-randP;
			absci = rand.nextInt(this.puits.getLargeur());
			if (elements[ordon][absci]==null) {
				indiceCouleur = rand.nextInt(Couleur.values().length);
				this.getElements()[ordon][absci]=new Element(absci,ordon,Couleur.values()[indiceCouleur]);
				nbElementPlace++;
			}
		}
	}
	public void ajouterElements(Piece piece) {
		
		for(int i = 0; i<piece.getElements().size();i++) {
			this.elements[piece.getElements().get(i).getCoordonnees().getOrdonnee()]
					[piece.getElements().get(i).getCoordonnees().getAbscisse()]=piece.getElements().get(i);
		}	
	}
	public void verifierEtSupprimerLignesCompletes() {
	    for (int i = 0; i < elements.length; i++) {
	        boolean ligneComplete = true;
	        for (int j = 0; j < elements[i].length; j++) {
	            if (elements[i][j] == null) {
	                ligneComplete = false;
	                break;
	            }
	        }
	        if (ligneComplete) {
	            supprimerLigne(i);
	            puits.incrementerScore(10);  // Incrémente le score pour chaque ligne complète
	            i--;
	        }
	    }
	}


    // Méthode pour supprimer une ligne et décaler les lignes au-dessus
    private void supprimerLigne(int ligneASupprimer) {
        for (int i = ligneASupprimer; i > 0; i--) {
            for (int j = 0; j < elements[i].length; j++) {
                elements[i][j] = elements[i - 1][j]; // Décaler chaque élément d'une ligne vers le bas
                if (elements[i][j] != null) {
                    elements[i][j].getCoordonnees().setOrdonnee(i); // Mettre à jour l'ordonnée de l'élément
                }
            }
        }
        // Nettoyer la ligne la plus haute après le décalage
        for (int j = 0; j < elements[0].length; j++) {
            elements[0][j] = null;
        }
    }

}	

package fr.eseo.e3.poo.projet.blox.modele;

import java.util.Random;

import fr.eseo.e3.poo.projet.blox.modele.pieces.IPiece;
import fr.eseo.e3.poo.projet.blox.modele.pieces.JPiece;
import fr.eseo.e3.poo.projet.blox.modele.pieces.LPiece;
import fr.eseo.e3.poo.projet.blox.modele.pieces.OPiece;
import fr.eseo.e3.poo.projet.blox.modele.pieces.Piece;
import fr.eseo.e3.poo.projet.blox.modele.pieces.SPiece;
import fr.eseo.e3.poo.projet.blox.modele.pieces.TPiece;
import fr.eseo.e3.poo.projet.blox.modele.pieces.ZPiece;

public class UsineDePiece {
	public static final int ALEATOIRE_COMPLET=0;
	public static final int ALEATOIRE_PIECE=1;
	public static final int CYCLIC=2;
	private static int mode = ALEATOIRE_COMPLET;
	private static int pieceCyclic = 0; 
	
	private UsineDePiece() {}
	
	public static void setMode (int modes) {
		if (modes==0) {
			mode=ALEATOIRE_COMPLET;
		}else if(modes==1) {
			mode=ALEATOIRE_PIECE;
		}else {
			mode=CYCLIC;
		}
	}
	
	public static Piece genererPiece() {
		Coordonnees coords = new Coordonnees(2, 3);
		Piece piece;
		Random randPiece = new Random();
		int ramdomPiece = randPiece.nextInt(7);
		if (mode==ALEATOIRE_COMPLET) {
			Random randCouleur = new Random();
			Couleur[] allColors = Couleur.values();
			Couleur randomColor = allColors[randCouleur.nextInt(allColors.length)];
			if(ramdomPiece==0) {
				piece = new OPiece(coords, randomColor);
			}else if(ramdomPiece==1){
				piece = new IPiece(coords, randomColor);
			}else if(ramdomPiece==2) {
				piece = new TPiece(coords, randomColor);
			}else if(ramdomPiece==3) {
				piece = new LPiece(coords, randomColor);
			}else if(ramdomPiece==4) {
				piece = new JPiece(coords, randomColor);
			}else if(ramdomPiece==5) {
				piece = new ZPiece(coords, randomColor);
			}else {
				piece = new SPiece(coords, randomColor);
			}
		}else if(mode==ALEATOIRE_PIECE) {
			if(ramdomPiece==0) {
				piece = new OPiece(coords, Couleur.ROUGE);
			}else if(ramdomPiece==1){
				piece = new IPiece(coords, Couleur.ORANGE);
			}else if(ramdomPiece==2) {
				piece = new TPiece(coords, Couleur.BLEU);
			}else if(ramdomPiece==3) {
				piece = new LPiece(coords, Couleur.VERT);
			}else if(ramdomPiece==4) {
				piece = new JPiece(coords, Couleur.JAUNE);
			}else if(ramdomPiece==5) {
				piece = new ZPiece(coords, Couleur.CYAN);
			}else {
				piece = new SPiece(coords, Couleur.VIOLET);
			}
		}else {
			if(pieceCyclic==0) {
				piece = new OPiece(coords, Couleur.ROUGE);
				pieceCyclic=1;
			}
			else if(pieceCyclic==1) {
				piece = new IPiece(coords, Couleur.ORANGE);
				pieceCyclic=2;
			}else if(pieceCyclic==2) {
				piece = new TPiece(coords, Couleur.BLEU);
				pieceCyclic=3;
			}else if(pieceCyclic==3) {
				piece = new LPiece(coords, Couleur.VERT);
				pieceCyclic=4;
			}else if(pieceCyclic==4) {
				piece = new JPiece(coords, Couleur.JAUNE);
				pieceCyclic=5;
			}else if(pieceCyclic==5) {
				piece = new ZPiece(coords, Couleur.CYAN);
				pieceCyclic=6;
			}else {
				piece = new SPiece(coords, Couleur.VIOLET);
				pieceCyclic=0;
			}
			
			
			
		}
		return piece;
	}
	
}

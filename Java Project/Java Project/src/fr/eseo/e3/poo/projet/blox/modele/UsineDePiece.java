package fr.eseo.e3.poo.projet.blox.modele;
import java.util.Random;

import fr.eseo.e3.poo.projet.blox.modele.pieces.IPiece;
import fr.eseo.e3.poo.projet.blox.modele.pieces.OPiece;
import fr.eseo.e3.poo.projet.blox.modele.pieces.Piece;

	public class UsineDePiece {

	    public  static final int CYCLIC = 1;
	    public  static final int ALEATOIRE_COMPLET = 2;
	    public  static final int ALEATOIRE_PIECE = 3;
	    static int x;
	    
	    private static Random random = new Random();

	    private  UsineDePiece() {
	        
	    }
	    public static int mode = ALEATOIRE_PIECE;

	    public static void setMode(int mode) {
	        UsineDePiece.mode = mode;
	    }

	    public static Piece genererPiece() {
	       Piece piece;
	        
	        switch (mode) {
	            case CYCLIC:
	                if (x  == 0) {
	                    piece = new OPiece(new Coordonnees(2, 3), Couleur.ROUGE);
	                } else if (x == 1) {
	                    piece = new IPiece(new Coordonnees(2, 3), Couleur.ORANGE);
	                } else if (x==2) {
	                    piece = new OPiece(new Coordonnees(2, 3), Couleur.ROUGE);
	                } else {
	                    piece = new IPiece(new Coordonnees(2, 3),Couleur.ORANGE);
	                }
	                x=(x+1)%4;
	                break;
	            case ALEATOIRE_COMPLET:
	                int typeAleatoire = random.nextInt(4);
	                int couleurAleatoire = random.nextInt(Couleur.values().length);
	                switch (typeAleatoire) {
	                    case 0:
	                        piece = new OPiece(new Coordonnees(2, 3), Couleur.values()[couleurAleatoire]);
	                        break;
	                    case 1:
	                        piece = new IPiece(new Coordonnees(2, 3), Couleur.values()[couleurAleatoire]);
	                        break;
	                    case 2:
	                        piece = new OPiece(new Coordonnees(2, 3), Couleur.values()[couleurAleatoire]);
	                        break;
	                    default:
	                        piece = new IPiece(new Coordonnees(2, 3), Couleur.values()[couleurAleatoire]);
	                        break;
	                }
	                break;
	            default: // mode ALEATOIRE_PIECE
	               
	                int type = random.nextInt(4);
	                switch (type) {
	                    case 0:
	                    	piece=new OPiece(new Coordonnees(2, 3), Couleur.ROUGE);
	                        
	                        break;
	                    case 1:
	                        piece = new IPiece(new Coordonnees(2, 3), Couleur.ORANGE);
	                        break;
	                    case 2:
	                        piece = new OPiece(new Coordonnees(2, 3), Couleur.ROUGE);
	                        break;
	                    default:
	                        piece = new IPiece(new Coordonnees(2, 3), Couleur.ORANGE);
	                        break;
	                }
	        }
	                
	        
	       
	        return piece;
	    }
	}


	
	



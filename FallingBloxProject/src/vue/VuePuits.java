package vue;

import javax.swing.JPanel;

import modele.Puits;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Graphics2D;

public class VuePuits extends JPanel {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final int TAILLE_PAR_DEFAUT = 20;
    private Puits puits;
    private int taille;
    private VuePiece vuePiece;  // Association to VuePiece

    public VuePuits(Puits puits) {
        this(puits, TAILLE_PAR_DEFAUT);
    }

    public VuePuits(Puits puits, int taille) {
        this.puits = puits;
        this.taille = taille;
        setPreferredSize(new Dimension(puits.getLargeur() * taille, puits.getProfondeur() * taille));
        setBackground(Color.WHITE);
    }

    public Puits getPuits() {
        return puits;
    }

    public int getTaille() {
        return taille;
    }

    public VuePiece getVuePiece() {
        return vuePiece;
    }

    public void setPuits(Puits puits) {
        this.puits = puits;
    }

    public void setTaille(int taille) {
        this.taille = taille;
        setPreferredSize(new Dimension(puits.getLargeur() * taille, puits.getProfondeur() * taille));
    }

    public void setVuePiece(VuePiece vuePiece) {
        this.vuePiece = vuePiece;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2D = (Graphics2D) g;
        drawGrid(g2D);
        if (vuePiece != null) {
            vuePiece.afficherPiece(g2D);
        }
    }

    private void drawGrid(Graphics2D g2D) {
        g2D.setColor(Color.LIGHT_GRAY);
        for (int i = 0; i < puits.getLargeur(); i++) {
            for (int j = 0; j < puits.getProfondeur(); j++) {
                g2D.drawRect(i * taille, j * taille, taille, taille);
            }
        }
    }
}

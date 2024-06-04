package fr.eseo.e3.poo.projet.blox.vue;

import java.awt.GridLayout;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.BorderFactory;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import fr.eseo.e3.poo.projet.blox.modele.pieces.Piece;
public class PanneauInformation extends JPanel {
    private JLabel scoreLabel;
    private JPanel nextPiecePanel;  // Panneau pour afficher la pièce suivante
    private VuePuits vuePuits;

    public PanneauInformation(VuePuits vuePuits) {
        this.setLayout(new BorderLayout());
        this.vuePuits = vuePuits;
        this.setBackground(Color.WHITE);
        this.setPreferredSize(new Dimension(150, this.vuePuits.getPuits().getProfondeur() * vuePuits.getTaille()));

        scoreLabel = new JLabel("Score: 0");
        this.add(scoreLabel, BorderLayout.NORTH);

        nextPiecePanel = new JPanel(new GridLayout(4, 4));  // Suppose que la pièce tient dans un grid 4x4
        nextPiecePanel.setPreferredSize(new Dimension(100, 100));
        nextPiecePanel.setBorder(BorderFactory.createTitledBorder("Next Piece"));
        this.add(nextPiecePanel, BorderLayout.CENTER);

        updateNextPieceDisplay(vuePuits.getPuits().getPieceSuivante());
     // Ajouter un PropertyChangeListener pour écouter les changements de score
        vuePuits.getPuits().addPropertyChangeListener(evt -> {
            if ("score".equals(evt.getPropertyName())) {
                scoreLabel.setText("Score: " + evt.getNewValue());
            }
        });
        
        // Ajouter un PropertyChangeListener pour écouter les changements de la pièce suivante
        vuePuits.getPuits().addPropertyChangeListener(evt -> {
            if ("Piece_Suivante".equals(evt.getPropertyName())) {
                updateNextPieceDisplay((Piece) evt.getNewValue());
            }
        });
    }

    private void updateNextPieceDisplay(Piece piece) {
        nextPiecePanel.removeAll();
        if (piece != null) {
            boolean[][] shape = piece.getShape();  // Suppose que Piece a une méthode getShape retournant un tableau 2D de booléens
            for (int i = 0; i < shape.length; i++) {
                for (int j = 0; j < shape[i].length; j++) {
                    JPanel cell = new JPanel();
                    cell.setBackground(shape[i][j] ? piece.getCouleur().getCouleurPourAffichage() : Color.WHITE);
                    nextPiecePanel.add(cell);
                }
            }
        }
        nextPiecePanel.revalidate();
        nextPiecePanel.repaint();
    }
}

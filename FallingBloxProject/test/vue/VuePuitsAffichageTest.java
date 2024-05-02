package vue;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import modele.Puits;

public class VuePuitsAffichageTest {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                createAndShowGUI();
            }
        });
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Test VuePuits");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Puits puits = new Puits(10, 20); // Assuming Puits constructor takes width and height as arguments
        VuePuits vuePuits = new VuePuits(puits);

        frame.add(vuePuits);
        frame.pack(); // Adjusts size of the JFrame to fit the preferred size of its contents
        frame.setLocationRelativeTo(null); // Center the window on the screen
        frame.setVisible(true);
    }
}

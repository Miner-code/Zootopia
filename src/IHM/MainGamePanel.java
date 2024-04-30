package IHM;


import javax.swing.*;
import java.awt.*;

public class MainGamePanel extends JFrame {
    public MainGamePanel() {
        setTitle("ZooTopia");

        // Récupérer la taille de l'écran
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = (int) screenSize.getWidth();
        int screenHeight = (int) screenSize.getHeight();

        // Définir la taille de la fenêtre à la taille de l'écran
        setSize(screenWidth, screenHeight);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Maximiser la fenêtre
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setUndecorated(true);
        setVisible(true);

        //------------------------------------------------------------

        // Créer une grille pour afficher les éléments du marché
        JPanel marketPanel = new JPanel(new GridLayout(1, 2));

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        mainPanel.setBackground(Color.WHITE);

        JPanel sidePanel = new JPanel(new BorderLayout());
        sidePanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        sidePanel.setBackground(Color.RED);

        marketPanel.add(mainPanel, BorderLayout.WEST);
        marketPanel.add(sidePanel, BorderLayout.WEST);

        // Ajouter la grille au centre de la fenêtre
        add(marketPanel, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        new MainGamePanel();
    }
}

package IHM.UI.Panels;

import IHM.Content.Drawers.ImagePanel;
import IHM.UI.ZooGridElement.EmptyZone;
import IHM.UI.ZooGridElement.Enclosure;

import javax.swing.*;
import java.awt.*;

public class MainPanel extends JPanel {

    private SidePanel sidePanel;

    public MainPanel(SidePanel sidePanel) {
        this.sidePanel = sidePanel;

        // Obtenir la taille de l'écran
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = (int) screenSize.getWidth();
        int mainPanelWidth = (int) (screenWidth * 0.65);
        int screenHeight = (int) screenSize.getHeight();

        // Création du panel principal
        setLayout(new BorderLayout());

        // Création du JLayeredPane pour superposer les calques
        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(new Dimension(mainPanelWidth, screenHeight)); // Définissez la taille selon vos besoins

        // Ajoutez le premier calque avec l'image de fond
        ImagePanel backgroundPanel = new ImagePanel("/IHM/Content/Images/bg-zoo-bottom.png");
        backgroundPanel.setBounds(0, 0, mainPanelWidth, screenHeight); // Position et taille du fond
        backgroundPanel.setOpaque(false);
        layeredPane.add(backgroundPanel, JLayeredPane.DEFAULT_LAYER);

        // Ajout des enclosures au deuxième calque
        JPanel gridPanel = new JPanel(new GridLayout(4, 4, 50, 50)); // Utilise GridLayout avec espacement horizontal et vertical de 40 pixels
        gridPanel.setOpaque(false);

        for (int i = 1; i <= 12; i++) {
            Enclosure enclosure = new Enclosure(0, "enclosure" + i, sidePanel);
            gridPanel.add(enclosure);
        }

        gridPanel.add(new EmptyZone());
        gridPanel.add(new EmptyZone());
        gridPanel.add(new EmptyZone());
        gridPanel.add(addNextTurn());

        gridPanel.setBounds(50, 50, (mainPanelWidth - 100), (screenHeight - 100)); // Position et taille du deuxième calque
        layeredPane.add(gridPanel, JLayeredPane.PALETTE_LAYER);

        // Ajoutez le troisième calque avec l'image supérieure
        ImagePanel topPanel = new ImagePanel("/IHM/Content/Images/bg-zoo-top.png");
        topPanel.setOpaque(false);
        topPanel.setBounds(0, 0, mainPanelWidth, screenHeight); // Position et taille de l'autre image
        layeredPane.add(topPanel, JLayeredPane.POPUP_LAYER);

        // Ajoutez le JLayeredPane au panel principal
        add(layeredPane, BorderLayout.CENTER);
    }

    public JPanel addNextTurn() {
        JPanel nextTurn = new JPanel(new BorderLayout());
        nextTurn.setBackground(Color.GRAY);
        nextTurn.add(new JLabel("Next Turn"), BorderLayout.WEST);
        return nextTurn;
    }
}

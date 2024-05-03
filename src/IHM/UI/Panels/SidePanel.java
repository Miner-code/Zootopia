package IHM.UI.Panels;

import IHM.Content.Drawers.ImagePanel;
import IHM.MainGamePanel;
import IHM.UI.Buttons.ButtonClear;
import IHM.UI.Buttons.ButtonClose;
import IHM.UI.Buttons.ButtonUpgrade;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SidePanel extends JPanel {

    private JLabel enclosureNameLabel;
    private JLabel levelLabel;
    private JButton cleanButton;
    private JButton upgradeButton;
    private JButton closeButton;
    private JPanel buttonPanel; // Déplacer la déclaration du buttonPanel ici

    private MainGamePanel mainGamePanel; // Référence au MainGamePanel pour le comportement du bouton de fermeture

    private boolean enclosureSelected = false; // Indicateur pour suivre si un enclos est sélectionné

    public SidePanel(MainGamePanel mainGamePanel) {
        this.mainGamePanel = mainGamePanel;

        // Obtenir la taille de l'écran
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = (int) screenSize.getWidth();
        int sidePanelWidth = (int) (screenWidth * 0.35);
        int screenHeight = (int) screenSize.getHeight();

        // Création du panel principal
        setLayout(new BorderLayout());

        // Création du JLayeredPane pour superposer les calques
        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(new Dimension(sidePanelWidth, screenHeight));

        // Ajout du premier calque avec l'image de fond
        ImagePanel backgroundPanel = new ImagePanel("/IHM/Content/Images/bg-side.png");
        backgroundPanel.setBounds(0, 0, sidePanelWidth, screenHeight);
        layeredPane.add(backgroundPanel, JLayeredPane.DEFAULT_LAYER);

        // Création du panel pour le contenu avec un GridLayout
        JPanel contentPanel = new JPanel(new GridLayout(0, 1));
        contentPanel.setOpaque(false); // Rendre le contenu transparent

        // Création du panel d'informations de l'enclos
        JPanel infoPanel = new JPanel(new BorderLayout());
        infoPanel.setOpaque(false); // Rendre le contenu transparent
        infoPanel.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));
        enclosureNameLabel = new JLabel("");
        levelLabel = new JLabel("");
        infoPanel.add(enclosureNameLabel, BorderLayout.NORTH);
        infoPanel.add(levelLabel, BorderLayout.CENTER);
        contentPanel.add(infoPanel);

        // Création du panel de boutons d'actions de l'enclos
        buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.setOpaque(false); // Rendre le contenu transparent
        cleanButton = new ButtonClear();
        upgradeButton = new ButtonUpgrade();
        closeButton = new ButtonClose();
        buttonPanel.add(cleanButton);
        buttonPanel.add(upgradeButton);
        buttonPanel.add(closeButton);
        buttonPanel.setVisible(false); // Initialiser les boutons comme cachés
        contentPanel.add(buttonPanel);

        // Ajout du contentPanel au JLayeredPane
        contentPanel.setBounds(0, 0, sidePanelWidth, screenHeight);
        layeredPane.add(contentPanel, JLayeredPane.PALETTE_LAYER);

        // Ajout du JLayeredPane au panel principal
        add(layeredPane, BorderLayout.CENTER);

        // Ajouter un écouteur d'action pour le bouton de fermeture
        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Effacer le contenu du SidePanel lors de la fermeture
                enclosureNameLabel.setText("");
                levelLabel.setText("");
                buttonPanel.setVisible(false); // Cacher les boutons
                enclosureSelected = false; // Réinitialiser l'état de sélection
            }
        });
    }

    // Méthode pour mettre à jour les informations de l'enclos affichées dans le SidePanel
    public void updateInfo(String name, int level) {
        SwingUtilities.invokeLater(() -> {
            enclosureNameLabel.setText("Nom de l'enclos: " + name);
            levelLabel.setText("Level: " + level);
            // Afficher les boutons lorsque les informations de l'enclos sont mises à jour
            if (!enclosureSelected) {
                buttonPanel.setVisible(true);
                enclosureSelected = true;
            }
        });
    }
}

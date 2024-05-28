package IHM.UI.Panels;

import IHM.Content.Drawers.ImagePanel;
import IHM.MainGamePanel;
import IHM.UI.Buttons.ButtonClear;
import IHM.UI.Buttons.ButtonClose;
import IHM.UI.Buttons.ButtonUpgrade;
import IHM.UI.ZooElement.Creature;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintStream;
import java.util.List;

public class SidePanel extends JPanel {

    private JLabel enclosureNameLabel;
    private JLabel levelLabel;
    private JPanel creaturesListPanel; // Ajouter un champ pour la liste des créatures
    private JButton cleanButton;
    private JButton upgradeButton;
    private JButton closeButton;
    private JPanel buttonPanel;
    private JTextArea consoleTextArea; // Ajouter un champ pour le JTextArea

    private MainGamePanel mainGamePanel;

    private boolean enclosureSelected = false;

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

        // Création du panel pour le contenu avec un GridLayout pour diviser en 2 zones
        JPanel contentPanel = new JPanel(new GridLayout(2, 1));
        contentPanel.setOpaque(false); // Rendre le contenu transparent

        // Création de la zone 1 pour les informations de l'enclos
        JPanel infoPanel = new JPanel(new BorderLayout());
        infoPanel.setOpaque(false); // Rendre le contenu transparent
        infoPanel.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));

        // Panneau pour les labels avec BorderLayout
        JPanel labelPanel = new JPanel(new BorderLayout());
        labelPanel.setOpaque(false);

        // Créer les labels avec la nouvelle police
        enclosureNameLabel = new JLabel("");
        levelLabel = new JLabel("");

        Font labelFont = new Font("Arial", Font.BOLD, 24); // Augmenter la taille de la police
        Color labelColor = new Color(139, 69, 19); // Couleur marron

        enclosureNameLabel.setFont(labelFont);
        enclosureNameLabel.setForeground(labelColor);
        levelLabel.setFont(labelFont);
        levelLabel.setForeground(labelColor);

        // Ajouter les labels au labelPanel
        labelPanel.add(enclosureNameLabel, BorderLayout.WEST);
        labelPanel.add(levelLabel, BorderLayout.EAST);

        // Ajouter le labelPanel à l'infoPanel
        infoPanel.add(labelPanel, BorderLayout.NORTH);

        // Ajouter un panel pour la liste des créatures
        creaturesListPanel = new JPanel();
        creaturesListPanel.setLayout(new BoxLayout(creaturesListPanel, BoxLayout.Y_AXIS));
        creaturesListPanel.setOpaque(false);
        infoPanel.add(new JScrollPane(creaturesListPanel), BorderLayout.CENTER);

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

        // Ajouter le infoPanel et le buttonPanel à la zone 1
        JPanel zone1 = new JPanel(new BorderLayout());
        zone1.setOpaque(false); // Rendre le contenu transparent
        zone1.add(infoPanel, BorderLayout.NORTH);
        zone1.add(buttonPanel, BorderLayout.SOUTH);

        // Création du JTextArea pour la console
        consoleTextArea = new JTextArea();
        consoleTextArea.setEditable(false);
        consoleTextArea.setFont(new Font("Courier New", Font.PLAIN, 14)); // Police de type console
        consoleTextArea.setForeground(Color.WHITE);
        consoleTextArea.setBackground(Color.BLACK); // Fond noir opaque
        consoleTextArea.setMargin(new Insets(50, 50, 50, 50)); // Ajouter du padding interne

        JScrollPane consoleScrollPane = new JScrollPane(consoleTextArea);
        consoleScrollPane.setOpaque(false);
        consoleScrollPane.getViewport().setOpaque(false);

        // Ajouter le JScrollPane avec le JTextArea dans la zone 2
        JPanel zone2 = new JPanel(new BorderLayout());
        zone2.setOpaque(false);
        zone2.add(consoleScrollPane, BorderLayout.CENTER);

        // Ajout des zones au contentPanel
        contentPanel.add(zone1);
        contentPanel.add(zone2);

        // Ajout du contentPanel au JLayeredPane
        contentPanel.setBounds(0, 0, sidePanelWidth, screenHeight);
        layeredPane.add(contentPanel, JLayeredPane.PALETTE_LAYER);

        // Ajout du JLayeredPane au panel principal
        add(layeredPane, BorderLayout.CENTER);

        // Ajouter un écouteur d'action pour le bouton de fermeture
        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                enclosureNameLabel.setText("");
                levelLabel.setText("");
                creaturesListPanel.removeAll(); // Effacer la liste des créatures
                creaturesListPanel.revalidate();
                creaturesListPanel.repaint();
                buttonPanel.setVisible(false); // Cacher les boutons
                enclosureSelected = false; // Réinitialiser l'état de sélection
            }
        });

        // Rediriger la sortie standard vers le JTextArea
        PrintStream consoleStream = new PrintStream(new TextAreaOutputStream(consoleTextArea));
        System.setOut(consoleStream);
        System.setErr(consoleStream);
    }

    // Méthode pour mettre à jour les informations de l'enclos affichées dans le SidePanel
    public void updateInfo(String name, int level, List<Creature> creatures) {
        SwingUtilities.invokeLater(() -> {
            enclosureNameLabel.setText(name);
            levelLabel.setText("Level: " + level);
            creaturesListPanel.removeAll();
            for (Creature creature : creatures) {
                JPanel creaturePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
                creaturePanel.setOpaque(false);
                JLabel creatureImageLabel = new JLabel(creature.getImageIcon());
                JLabel creatureNameLabel = new JLabel(creature.getName());
                creatureNameLabel.setFont(new Font("Arial", Font.PLAIN, 18)); // Taille et style de police pour les noms de créatures
                creatureNameLabel.setForeground(Color.WHITE); // Couleur des noms de créatures
                creaturePanel.add(creatureImageLabel);
                creaturePanel.add(creatureNameLabel);
                creaturesListPanel.add(creaturePanel);
            }
            creaturesListPanel.revalidate();
            creaturesListPanel.repaint();
            if (!enclosureSelected) {
                buttonPanel.setVisible(true);
                enclosureSelected = true;
            }
        });
    }
}

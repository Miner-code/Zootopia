package IHM;

import IHM.UI.Panels.*;
import IHM.UI.ZooGridElement.EnclosureIHM;
import Zoo.Creature.Creature;

import javax.swing.*;
import java.awt.*;
import java.util.List;

/**
 * The type Main game panel.
 */
public class MainGamePanel extends JFrame {

    private SidePanel sidePanel;

    /**
     * Instantiates a new Main game panel.
     *
     * @param arrayCreatures the array creatures
     * @param enclosureIHMS  the enclosure ihms
     */
    public MainGamePanel(List<Creature> arrayCreatures, List<EnclosureIHM> enclosureIHMS) {
        setTitle("ZooTopia");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Maximiser la fenêtre
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setUndecorated(true);//Loukas a changé la taille pour coder, remettre a la bonne taille !!!!

        //------------------------------------------------------------


        // Utiliser BorderLayout pour le conteneur principal
        setLayout(new BorderLayout());

        // Créer une grille pour afficher les éléments du marché
        JPanel gamePanel = new JPanel(new GridBagLayout());

        sidePanel = new SidePanel(this);
        JPanel mainPanel = new MainPanel(sidePanel,arrayCreatures,enclosureIHMS);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;

        // Configuration des contraintes pour mainPanel
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0.5; // 65% de la largeur pour mainPanel
        gbc.weighty = 1; // 100% de la hauteur
        gamePanel.add(mainPanel, gbc);

        // Configuration des contraintes pour sidePanel
        gbc.gridx = 1;
        gbc.weightx = 0.5; // 35% de la largeur pour sidePanel
        gamePanel.add(sidePanel, gbc);

        // Ajouter la grille au centre de la fenêtre
        add(gamePanel, BorderLayout.CENTER);

        //------------------------------------------------------------

        // Rendre la fenêtre visible après avoir ajouté tous les composants
        setVisible(true);


    }

}

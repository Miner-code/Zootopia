package IHM.UI.ZooGridElement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import IHM.Content.Drawers.ImagePanel;
import IHM.UI.Panels.SidePanel;

public class Enclosure extends JPanel {
    public Enclosure(Integer level, String name, SidePanel sidePanel) {
        setLayout(new BorderLayout()); // Utiliser BorderLayout pour contenir l'image et les informations
        ImagePanel imagePanel = new ImagePanel("/IHM/Content/Images/enclosure-earth.png"); // Charger l'image d'arrière-plan
        imagePanel.setLayout(new BorderLayout());

        // Ajouter le nom et le niveau de l'enclos
        JLabel nameLabel = new JLabel(name);
        nameLabel.setHorizontalAlignment(SwingConstants.CENTER);
        JLabel levelLabel = new JLabel("Level: " + level);
        levelLabel.setHorizontalAlignment(SwingConstants.CENTER);

        // Ajouter le nom et le niveau au centre de l'image
        JPanel infoPanel = new JPanel(new GridLayout(2, 1));
        infoPanel.setOpaque(false); // Rendre le panel transparent pour afficher l'image d'arrière-plan
        infoPanel.add(nameLabel);
        infoPanel.add(levelLabel);
        imagePanel.add(infoPanel, BorderLayout.CENTER);

        add(imagePanel, BorderLayout.CENTER);

        final MutableInteger currentLevel = new MutableInteger(level); // Utiliser une classe d'enveloppe pour stocker le niveau actuel
        final String enclosureName = name;

        // Ajouter un écouteur de souris pour détecter les clics
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                currentLevel.increment(); // Incrémenter le niveau lors d'un clic
                setBackground(getBackgroundColor(currentLevel.getValue())); // Mettre à jour la couleur de fond

                sidePanel.updateInfo(enclosureName, currentLevel.getValue());
            }
        });
    }

    private Color getBackgroundColor(Integer level) {
        switch (level) {
            case 0:
                return Color.GRAY;
            case 1:
                return Color.GREEN;
            case 2:
                return Color.RED;
            default:
                return Color.BLUE;
        }
    }

    // Classe d'enveloppe pour un entier mutable
    private static class MutableInteger {
        private int value;

        public MutableInteger(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public void increment() {
            value++;
        }
    }
}

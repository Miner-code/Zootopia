package IHM.UI.ZooGridElement;

import IHM.Content.Drawers.ImagePanel;

import javax.swing.*;
import java.awt.*;

public class EmptyZone extends JPanel {
    public EmptyZone() {
        setLayout(new BorderLayout()); // Utiliser BorderLayout pour contenir l'image et les informations
        ImagePanel imagePanel = new ImagePanel("/IHM/Content/Images/empty-zone-bg.png"); // Charger l'image d'arrière-plan
        imagePanel.setLayout(new BorderLayout());

        JLabel Label = new JLabel("Empty Zone");
        Label.setHorizontalAlignment(SwingConstants.CENTER);

        // Ajouter le nom et le niveau au centre de l'image
        JPanel infoPanel = new JPanel(new GridLayout(1, 1));
        infoPanel.setOpaque(false); // Rendre le panel transparent pour afficher l'image d'arrière-plan
        infoPanel.add(Label);
        imagePanel.add(infoPanel, BorderLayout.CENTER);

        add(imagePanel, BorderLayout.CENTER);
    }
}

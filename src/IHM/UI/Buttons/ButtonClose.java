package IHM.UI.Buttons;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Objects;

public class ButtonClose extends JButton {

    public ButtonClose() {
        // Charger l'image originale
        ImageIcon originalIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/IHM/Content/Images/Buttons/button-close-up.png")));

        // Redimensionner l'image originale à la taille souhaitée
        Image scaledImage = originalIcon.getImage().getScaledInstance(72, 72, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);

        // Charger l'image enfoncée (clic gauche enfoncé)
        ImageIcon pressedIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/IHM/Content/Images/Buttons/button-close-down.png")));

        // Redimensionner l'image originale à la taille souhaitée
        Image scaledPressedImage = pressedIcon.getImage().getScaledInstance(72, 72, Image.SCALE_SMOOTH);
        ImageIcon scaledPressedIcon = new ImageIcon(scaledPressedImage);

        setIcon(scaledIcon); // Définir l'image originale comme icône du bouton
        setBorderPainted(false); // Supprimer la bordure du bouton
        setContentAreaFilled(false); // Supprimer le remplissage de la zone de contenu

        // Ajouter un écouteur de souris pour détecter les clics
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                setIcon(scaledPressedIcon); // Changer l'image du bouton lors du clic gauche enfoncé
            }
            public void mouseReleased(MouseEvent e) {
                setIcon(scaledIcon); // Changer l'image du bouton lors du clic gauche enfoncé
            }
        });
    }
}

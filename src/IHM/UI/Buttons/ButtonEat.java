package IHM.UI.Buttons;

import Zoo.Creature.Creature;
import Zoo.Creature.Action.Hungry;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Objects;

/**
 * The type Button eat.
 */
public class ButtonEat extends JButton {

    /**
     * Instantiates a new Button eat.
     *
     * @param creature the creature
     */
    public ButtonEat(Creature creature) {
        // Load the original image
        ImageIcon originalIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/IHM/Content/Images/Buttons/button-clear-up.png")));

        // Resize the original image to the desired size
        Image scaledImage = originalIcon.getImage().getScaledInstance(72, 72, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);

        // Load the pressed image (left click pressed)
        ImageIcon pressedIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/IHM/Content/Images/Buttons/button-clear-down.png")));

        // Resize the pressed image to the desired size
        Image scaledPressedImage = pressedIcon.getImage().getScaledInstance(72, 72, Image.SCALE_SMOOTH);
        ImageIcon scaledPressedIcon = new ImageIcon(scaledPressedImage);

        setIcon(scaledIcon); // Set the original image as the button icon
        setBorderPainted(false); // Remove the button border
        setContentAreaFilled(false); // Remove the content area fill

        // Add a mouse listener to detect clicks
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                setIcon(scaledPressedIcon); // Change the button image when the left click is pressed
                Hungry.eat(creature); // Feed the creature
                System.out.println(creature.getName() + " has been fed."); // Debugging statement
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                setIcon(scaledIcon); // Change the button image when the left click is released
            }
        });
    }
}

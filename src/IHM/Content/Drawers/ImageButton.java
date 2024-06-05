package IHM.Content.Drawers;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;
import javax.imageio.ImageIO;

/**
 * The type Image button.
 */
public class ImageButton extends JButton {
    private BufferedImage buttonImage;

    /**
     * Instantiates a new Image button.
     *
     * @param imagePath the image path
     */
    public ImageButton(String imagePath) {
        try {
            buttonImage = ImageIO.read(Objects.requireNonNull(getClass().getResource(imagePath)));
            setContentAreaFilled(false);
            setBorderPainted(false);
            setFocusPainted(false);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        if (buttonImage != null) {
            g.drawImage(buttonImage, 0, 0, getWidth(), getHeight(), this);
        }
        super.paintComponent(g);
    }
}

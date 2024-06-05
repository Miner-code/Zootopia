package IHM.UI.ZooElement;

import javax.swing.*;
import java.awt.*;

/**
 * The type Creature img.
 */
public class CreatureImg {
    private String name;
    private CreatureType type;
    private Point position;

    /**
     * Instantiates a new Creature img.
     *
     * @param name the name
     * @param type the type
     */
    public CreatureImg(String name, CreatureType type) {
        this.name = name;
        this.type = type;
        this.position = new Point(0, 0); // Position initiale par défaut
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets type.
     *
     * @return the type
     */
    public CreatureType getType() {
        return type;
    }

    /**
     * Gets image icon.
     *
     * @return the image icon
     */
    public ImageIcon getImageIcon() {
        return type.getImageIcon();
    }

    /**
     * Gets position.
     *
     * @return the position
     */
    public Point getPosition() {
        return position;
    }

    /**
     * Sets position.
     *
     * @param x the x
     * @param y the y
     */
    public void setPosition(int x, int y) {
        this.position.setLocation(x, y);
    }
}

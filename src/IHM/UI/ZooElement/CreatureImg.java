package IHM.UI.ZooElement;

import javax.swing.*;
import java.awt.*;

public class CreatureImg {
    private String name;
    private CreatureType type;
    private Point position;

    public CreatureImg(String name, CreatureType type) {
        this.name = name;
        this.type = type;
        this.position = new Point(0, 0); // Position initiale par défaut
    }

    public String getName() {
        return name;
    }

    public CreatureType getType() {
        return type;
    }

    public ImageIcon getImageIcon() {
        return type.getImageIcon();
    }

    public Point getPosition() {
        return position;
    }

    public void setPosition(int x, int y) {
        this.position.setLocation(x, y);
    }
}

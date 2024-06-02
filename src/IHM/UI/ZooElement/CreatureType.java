package IHM.UI.ZooElement;

import javax.swing.*;
import java.util.Objects;
import java.util.Random;

public enum CreatureType {
    DRAGON("/IHM/Content/Images/Creatures/dragon.png"),
    UNICORN("/IHM/Content/Images/Creatures/unicorn.png"),
    WEREWOLF("/IHM/Content/Images/Creatures/werewolf.png"),
    MERMAID("/IHM/Content/Images/Creatures/mermaid.png"),
    KRAKEN("/IHM/Content/Images/Creatures/mermaid.png"),
    MEGALODON("/IHM/Content/Images/Creatures/mermaid.png"),
    PHEONIX("/IHM/Content/Images/Creatures/mermaid.png"),
    NYMPH("/IHM/Content/Images/Creatures/mermaid.png");
    private final String imagePath;
    private static final Random RANDOM = new Random();

    CreatureType(String imagePath) {
        this.imagePath = imagePath;
    }

    public ImageIcon getImageIcon() {
        return new ImageIcon(Objects.requireNonNull(getClass().getResource(imagePath)));
    }

    public static CreatureType getRandomType() {
        CreatureType[] values = CreatureType.values();
        return values[RANDOM.nextInt(values.length)];
    }

    public static CreatureType getType(String typeName) {
        switch (typeName.toLowerCase()) {
            case "dragon":
                return DRAGON;
            case "unicorn":
                return UNICORN;
            case "werewolf":
                return WEREWOLF;
            case "mermaid":
                return MERMAID;
            case "kraken":
                return KRAKEN;
            case "megalodon":
                return MEGALODON;
            case "pheonix":
                return PHEONIX;
            case "nymph":
                return NYMPH;
            default:
                return null;
        }
    }
}

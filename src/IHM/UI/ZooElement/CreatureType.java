package IHM.UI.ZooElement;

import javax.swing.*;
import java.util.Objects;
import java.util.Random;

/**
 * The enum Creature type.
 */
public enum CreatureType {
    /**
     * Dragon creature type.
     */
    DRAGON("/IHM/Content/Images/Creatures/dragon.png"),
    /**
     * Unicorn creature type.
     */
    UNICORN("/IHM/Content/Images/Creatures/unicorn.png"),
    /**
     * Werewolf creature type.
     */
    WEREWOLF("/IHM/Content/Images/Creatures/werewolf.png"),
    /**
     * Mermaid creature type.
     */
    MERMAID("/IHM/Content/Images/Creatures/mermaid.png"),
    /**
     * Kraken creature type.
     */
    KRAKEN("/IHM/Content/Images/Creatures/kraken.png"),
    /**
     * Megalodon creature type.
     */
    MEGALODON("/IHM/Content/Images/Creatures/megalodon.png"),
    /**
     * Pheonix creature type.
     */
    PHEONIX("/IHM/Content/Images/Creatures/phoenix.png"),
    /**
     * Nymph creature type.
     */
    NYMPH("/IHM/Content/Images/Creatures/nymphe.png");

    private final String imagePath;
    private static final Random RANDOM = new Random();

    CreatureType(String imagePath) {
        this.imagePath = imagePath;
    }

    /**
     * Gets image icon.
     *
     * @return the image icon
     */
    public ImageIcon getImageIcon() {
        return new ImageIcon(Objects.requireNonNull(getClass().getResource(imagePath)));
    }

    /**
     * Gets random type.
     *
     * @return the random type
     */
    public static CreatureType getRandomType() {
        CreatureType[] values = CreatureType.values();
        return values[RANDOM.nextInt(values.length)];
    }

    /**
     * Gets type.
     *
     * @param typeName the type name
     * @return the type
     */
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

    /**
     * Gets image path.
     *
     * @return the image path
     */
    public String getImagePath() {
        return imagePath;
    }
}

package Zoo.Creature.Type;

import Zoo.Creature.Creature;

/**
 * The type Swimmer.
 */
public class Swimmer extends Type {
    /**
     * Instantiates a new Swimmer.
     */
    public Swimmer() {
        super("Swimmer");
    }

    /**
     * Swim.
     *
     * @param creature the creature
     */
    public static void swim(Creature creature) {
        System.out.println(creature.getName() + " bruit des vagues");
    }
}

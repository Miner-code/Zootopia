package Zoo.Creature.Type;

import Zoo.Creature.Creature;

/**
 * The type Flying.
 */
public class Flying extends Type {
    /**
     * Instantiates a new Flying.
     */
    public Flying() {
        super("Flying");
    }

    /**
     * Fly.
     *
     * @param creature the creature
     */
    public static void fly(Creature creature) {
        System.out.println(creature.getName() + " waw il vole !!!");
    }
}

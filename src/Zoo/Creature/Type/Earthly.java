package Zoo.Creature.Type;

import Zoo.Creature.Creature;

/**
 * The type Earthly.
 */
public class Earthly extends Type{
    /**
     * Instantiates a new Earthly.
     */
    public Earthly() {
        super("Earthly");
    }

    /**
     * Run.
     *
     * @param creature the creature
     */
    public static void run(Creature creature) {
        System.out.println(creature.getName() + " galop galop galop ! ! !");
    }
}

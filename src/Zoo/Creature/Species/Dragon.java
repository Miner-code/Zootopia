package Zoo.Creature.Species;

import Zoo.Creature.Action.Health;
import Zoo.Creature.Action.Hungry;
import Zoo.Creature.Action.Slept;
import Zoo.Creature.Creature;
import Zoo.Creature.Type.Flying;
import Zoo.Creature.Type.Type;


/**
 * The type Dragon.
 */
public class Dragon extends Creature {
    /**
     * The Type.
     */
    public Type type;

    /**
     * Instantiates a new Dragon.
     *
     * @param name   the name
     * @param sex    the sex
     * @param age    the age
     * @param size   the size
     * @param weight the weight
     * @param hungry the hungry
     * @param slept  the slept
     * @param health the health
     */
    public Dragon(String name, boolean sex, int age, double size, double weight, Hungry hungry, Slept slept, Health health) {
        super(name, sex, age, "Dragon", size, weight,hungry, slept, health);
        this.type = new Flying();
    }
    @Override
    public Type getType() {
        return type;
    }

}

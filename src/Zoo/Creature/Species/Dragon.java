package Zoo.Creature.Species;

import Zoo.Creature.Action.Health;
import Zoo.Creature.Action.Hungry;
import Zoo.Creature.Action.Slept;
import Zoo.Creature.Creature;
import Zoo.Creature.Type.Flying;
import Zoo.Creature.Type.Type;


public class Dragon extends Creature {
    public Type type;
    public Dragon(String name, boolean sex, int age, double size, double weight, Hungry hungry, Slept slept, Health health) {
        super(name, sex, age, "Dragon", size, weight,hungry, slept, health);
        this.type = new Flying();
    }
    @Override
    public Type getType() {
        return type;
    }

}

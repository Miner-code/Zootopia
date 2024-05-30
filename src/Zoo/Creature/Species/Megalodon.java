package Zoo.Creature.Species;

import Zoo.Creature.Action.Health;
import Zoo.Creature.Action.Hungry;
import Zoo.Creature.Action.Slept;
import Zoo.Creature.Creature;
import Zoo.Creature.Type.Swimmer;
import Zoo.Creature.Type.Type;

import java.security.PublicKey;

public class Megalodon extends Creature {
    public Type type;

    public Megalodon(String name, boolean sex, int age, double size, double weight, Hungry hungry, Slept slept, Health health) {
        super(name, sex, age, "Megalodon", size, weight,hungry, slept, health);
        this.type = new Swimmer();
    }
    @Override
    public Type getType() {
        return type;
    }
}

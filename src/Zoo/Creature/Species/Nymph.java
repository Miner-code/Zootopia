package Zoo.Creature.Species;
import Zoo.Creature.Action.Health;
import Zoo.Creature.Action.Hungry;
import Zoo.Creature.Action.Slept;
import Zoo.Creature.Creature;
import Zoo.Creature.Type.Earthly;
import Zoo.Creature.Type.Type;

public class Nymph extends Creature {
    public Type type;
    public Nymph(String name, boolean sex, int age, double size, double weight, Hungry hungry, Slept slept, Health health) {
        super(name, sex, age, "Nymph", size, weight,hungry, slept, health);
        this.type = new Earthly();
    }
    @Override
    public Type getType() {
        return type;
    }
}

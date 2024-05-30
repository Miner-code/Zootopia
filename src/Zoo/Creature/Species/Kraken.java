package Zoo.Creature.Species;
import Zoo.Creature.Action.Health;
import Zoo.Creature.Action.Hungry;
import Zoo.Creature.Action.Slept;
import Zoo.Creature.Creature;
import Zoo.Creature.Type.Swimmer;
import Zoo.Creature.Type.Type;

public class Kraken extends Creature {
    public Type type;

    public Kraken(String name, boolean sex, int age, double size, double weight, Hungry hungry, Slept slept, Health health) {
        super(name, sex, age, "Kraken", size, weight,hungry, slept, health);
        this.type = new Swimmer();
    }
    @Override
    public Type getType() {
        return type;
    }
}

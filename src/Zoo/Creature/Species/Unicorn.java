package Zoo.Creature.Species;
import Zoo.Creature.Type.Earthly;
import Zoo.Creature.Type.Type;

public class Unicorn extends Species{
    public Type type;

    public Unicorn() {
        super("Unicorn");
        this.type = new Earthly();
    }

    public Type getType() {
        return type;
    }
}

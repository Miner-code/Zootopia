package Zoo.Creature.Species;
import Zoo.Creature.Type.Earthly;
import Zoo.Creature.Type.Type;

public class Nymph extends Species {
    public Type type;
    public Nymph() {
        super("Nymph");
        this.type = new Earthly();
    }
    public Type getType(){return type;}
}

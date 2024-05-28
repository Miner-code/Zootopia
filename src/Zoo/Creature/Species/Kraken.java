package Zoo.Creature.Species;
import Zoo.Creature.Type.Swimmer;
import Zoo.Creature.Type.Type;

public class Kraken extends Species{
    public Type type;
    public Kraken() {
        super("Kraken");
        this.type = new Swimmer();
    }
    public Type getType(){return type;}
}

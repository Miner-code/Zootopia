package Zoo.Creature.Species;

import Zoo.Creature.Type.Earthly;
import Zoo.Creature.Type.Type;

public class Werewolf extends Species{
    public Type type;
    public Werewolf() {
        super("Werewolf");
        this.type = new Earthly();
    }
    public Type getType(){return type;}
}

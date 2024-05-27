package Zoo.Creature.Species;

import Zoo.Creature.Type.Swimmer;
import Zoo.Creature.Type.Type;

import java.security.PublicKey;

public class Megalodon extends Species{
    public Type type;
    public Megalodon(){
        super("Megalodon");
        this.type = new Swimmer();
    }
    public Type getType(){return type;}
}

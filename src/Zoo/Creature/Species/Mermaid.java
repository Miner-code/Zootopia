package Zoo.Creature.Species;

import Zoo.Creature.Type.Swimmer;
import Zoo.Creature.Type.Type;

public class Mermaid extends Species {
    public Type type;
    public Mermaid() {
        super("Mermaid");
        this.type = new Swimmer();
    }
    public Type getType() {return type;}
}

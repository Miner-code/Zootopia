package Zoo.Creature.Species;

import Zoo.Creature.Type.Flying;
import Zoo.Creature.Type.Type;


public class Dragon extends Species {
    public Type type;
    public Dragon() {
        super("Dragon");
        this.type = new Flying();
    }
    public Type getType(){return type;}
}

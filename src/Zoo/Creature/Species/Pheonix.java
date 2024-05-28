package Zoo.Creature.Species;


import Zoo.Creature.Type.Flying;
import Zoo.Creature.Type.Type;

public class Pheonix extends Species{
    public Type type;
    public Pheonix() {
        super("Pheonix");
        this.type = new Flying();
    }
    public Type getType(){return type;}
}

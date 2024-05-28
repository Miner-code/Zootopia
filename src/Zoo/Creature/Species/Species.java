package Zoo.Creature.Species;

import Zoo.Creature.Creature;
import Zoo.Creature.Type.Earthly;
import Zoo.Creature.Type.Flying;
import Zoo.Creature.Type.Swimmer;
import Zoo.Creature.Type.Type;

public abstract class Species {
    private String scpeciesName;
    public Type type;
    public Species(String scpeciesName) {
        this.scpeciesName = scpeciesName;
    }

    public String getScpeciesName() {
        return scpeciesName;
    }
    public Type getType(){return type;}
    @Override
    public String toString() {
        return scpeciesName;
    }


}

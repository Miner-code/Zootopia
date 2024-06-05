package Zoo.Creature.Species;

import Zoo.Creature.Creature;
import Zoo.Creature.Type.Earthly;
import Zoo.Creature.Type.Flying;
import Zoo.Creature.Type.Swimmer;
import Zoo.Creature.Type.Type;

/**
 * The type Species.
 */
public abstract class Species {
    private String scpeciesName;
    /**
     * The Type.
     */
    public Type type;

    /**
     * Instantiates a new Species.
     *
     * @param scpeciesName the scpecies name
     */
    public Species(String scpeciesName) {
        this.scpeciesName = scpeciesName;
    }

    /**
     * Gets scpecies name.
     *
     * @return the scpecies name
     */
    public String getScpeciesName() {
        return scpeciesName;
    }

    /**
     * Get type type.
     *
     * @return the type
     */
    public Type getType(){return type;}
    @Override
    public String toString() {
        return scpeciesName;
    }


}

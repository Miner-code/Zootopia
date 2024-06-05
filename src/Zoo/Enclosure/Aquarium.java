package Zoo.Enclosure;

import Zoo.Creature.Creature;
import Zoo.Creature.Species.*;


/**
 * The type Aquarium.
 */
public class Aquarium extends Enclosure {

    /**
     * The Basin depth.
     */
    int basinDepth;
    /**
     * The Water salinity.
     */
    int waterSalinity;

    /**
     * Instantiates a new Aquarium.
     *
     * @param name          the name
     * @param basinDepth    the basin depth
     * @param waterSalinity the water salinity
     */
    public Aquarium(String name, int basinDepth, int waterSalinity) {
        super(name, "aquarium");
        this.basinDepth = basinDepth;
        this.waterSalinity = waterSalinity;
    }
    @Override
    public void displayCharacteristics() {
        super.displayCharacteristics();
        System.out.println("Profondeur du bassin : " + this.basinDepth);
        System.out.println("Salinité de l'eau : " + this.waterSalinity);
    }

}
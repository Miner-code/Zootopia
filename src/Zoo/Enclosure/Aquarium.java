package Zoo.Enclosure;

import Zoo.Creature.Creature;
import Zoo.Creature.Species.*;


public class Aquarium extends Enclosure {

    int basinDepth;
    int waterSalinity;

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
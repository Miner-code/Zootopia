package Zoo.Enclosure;

import Zoo.Creature.Creature;
import Zoo.Creature.Megalodon;
import Zoo.Creature.Kraken;
import Zoo.Creature.Mermaid;
import Zoo.Creature.Dragon;

public class Aquarium extends Enclosure {
    double basinDepth;
    double waterSalinity;

    public Aquarium(String name, double area, double basinDepth, double waterSalinity) {
        super(name, area);
        this.basinDepth = basinDepth;
        this.waterSalinity = waterSalinity;
    }

    @Override
    public void displayCharacteristics() {
        super.displayCharacteristics();
        System.out.println("Profondeur du bassin : " + this.basinDepth);
        System.out.println("Salinité de l'eau : " + this.waterSalinity);
    }

    @Override
    public boolean addCreature(Creature creature) {
        if (creature instanceof Megalodon || creature instanceof Kraken || creature instanceof Mermaid || creature instanceof Dragon) {
            return super.addCreature(creature);
        } else {
            System.out.println("This type of creature cannot be added to this aquarium.");
            return false;
        }
    }
}

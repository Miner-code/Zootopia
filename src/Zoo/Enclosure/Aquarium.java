package Zoo.Enclosure;

import Zoo.Creature.*;

public class Aquarium extends Enclosure {
    double basinDepth;
    double waterSalinity;

    public Aquarium(String name, int size, double basinDepth, double waterSalinity) {
        super(name, size);
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

package Zoo.Enclosure;

import Zoo.Creature.Creature;
import Zoo.Creature.Dragon;
import Zoo.Creature.Phoenix;

public class Aviary extends Enclosure {
    double height;

    public Aviary(String name, double area, double height) {
        super(name, area);
        this.height = height;
    }

    @Override
    public void displayCharacteristics() {
        super.displayCharacteristics();
        System.out.println("Height: " + this.height);
    }

    @Override
    public boolean addCreature(Creature creature) {
        if (creature instanceof Dragon || creature instanceof Phoenix) {
            return super.addCreature(creature);
        } else {
            System.out.println("This type of creature cannot be added to this aviary.");
            return false;
        }
    }
}

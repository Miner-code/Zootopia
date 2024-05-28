package Zoo.Creature.Type;

import Zoo.Creature.Creature;

public class Swimmer extends Type {
    public Swimmer() {
        super("Swimmer");
    }

    public static void swim(Creature creature) {
        System.out.println(creature.getName() + " bruit des vagues");
    }
}

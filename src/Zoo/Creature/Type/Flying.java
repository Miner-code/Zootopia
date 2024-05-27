package Zoo.Creature.Type;

import Zoo.Creature.Creature;

public class Flying extends Type {
    public Flying() {
        super("Flying");
    }

    public static void fly(Creature creature) {
        System.out.println(creature.getName() + " waw il vole !!!");
    }
}

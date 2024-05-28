package Zoo.Creature.Type;

import Zoo.Creature.Creature;

public class Earthly extends Type{
    public Earthly() {
        super("Earthly");
    }
    public static void run(Creature creature) {
        System.out.println(creature.getName() + " galop galop galop ! ! !");
    }
}

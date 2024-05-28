package Zoo.Creature.Type;

import Zoo.Creature.Creature;
import Zoo.Creature.Type.*;

import javax.swing.*;

public abstract class Type {
    private String typeName;

    public Type(String typeName) {
        this.typeName = typeName;
    }

    public String getTypeName() {
        return typeName;
    }

    @Override
    public String toString() {
        return typeName;
    }

    public static void makeAction(Creature creature) {
        // Si la créature existe
        if (creature.getName() != null){

            double number = Math.random();
            if(number > 0.9){
                makeShout(creature);
            }
            if (number < 0.1) {
                switch (creature.getSpecies().getType().getTypeName()) {
                    case "Flying":
                        Flying.fly(creature);
                        break;
                    case "Earthly":
                        Earthly.run(creature);
                        break;
                    case "Swimmer":
                        Swimmer.swim(creature);
                        break;
                }
            }
        }
    }
    public static void makeShout(Creature creature) {
        System.out.println(creature.getName() + " WAAAW" );
    }
}
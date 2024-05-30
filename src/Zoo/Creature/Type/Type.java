package Zoo.Creature.Type;

import Zoo.Creature.Creature;
import Zoo.Creature.Species.Dragon;
import Zoo.Creature.Species.Kraken;
import Zoo.Creature.Species.Megalodon;
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
            if (number < 0.15) {
                Type type = creature.getType();
                if (type instanceof Flying) {
                    ((Flying) type).fly(creature);
                } else if (type instanceof Swimmer) {
                    ((Swimmer) type).swim(creature);
                } else if (type instanceof Earthly) {
                    ((Earthly) type).run(creature);
                }
            }
        }
    }
    public static void makeShout(Creature creature) {
        System.out.println(creature.getName() + " WAAAW" );
    }
}
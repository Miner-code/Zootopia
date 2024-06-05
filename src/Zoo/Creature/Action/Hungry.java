package Zoo.Creature.Action;

import IHM.UI.ZooGridElement.EnclosureIHM;
import Zoo.Creature.Creature;

import java.util.Scanner;
import java.util.List;
import static Zoo.Creature.Action.Health.removeHP;

public class Hungry {
    public int eat ;


    public Hungry(int eat) {
        this.eat = eat;
    }

    public int isEat() {
        return eat;
    }

    public int getEat() {
        return eat;
    }

    public void setEat(int eat) {
        this.eat = eat;
    }

    @Override
    public String toString() {
        return "Hungry{" +
                "eat=" + eat +
                '}';
    }

    public static void makeHungry(Creature creature, List<Creature> creatures, EnclosureIHM enclosureIHM) {
        if (creature.getName() != null){
            creature.getHungry().setEat(creature.getHungry().getEat() - 1);
            if (creature.getHungry().getEat() <= 0) {
                System.out.println("\n[ALERTE] " + creature.getName() + " a faim\n");
                removeHP(creature,creatures,enclosureIHM);
                return;
            }
            //System.out.println(creature.getName() + " a " + creature.getHungry().getEat() + " de nourriture ");
        }

    }


    public static void eat(Creature creature){
        if (creature.getName() != null){
            creature.getHungry().setEat(creature.getHungry().getEat() + 4);
            System.out.println("[#] " + creature.getName() + " a correctement été nourri");
        }
    }

}

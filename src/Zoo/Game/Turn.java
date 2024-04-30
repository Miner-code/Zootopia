package Zoo.Game;
import java.util.*;
import Zoo.Creature.*;

public class Turn {

    // Turn a besoins de a liste des créatures existant
    public Turn(List<Creature> creatures) {

        // Pour chaque créature faire l'itération suivante
        for (Creature creature : creatures) {
            // Appeler la function makeHungry avec comme paramètre la créature
            //makeHungry(creature);

            // Appeler la function makeSlept avec comme paramètre la créature
            makeSlept(creature);
        }
    }

    public void makeHungry(Creature creature) {
        creature.getHungry().setEat(creature.getHungry().getEat()-1);
        if (creature.getHungry().getEat() == 0) {
            System.out.println(creature.getName() + " a faim");
        }
        System.out.println(creature.getName());
        System.out.println(creature.getHungry().getEat());
    }

    public void makeSlept(Creature creature) {
        creature.getSlept().setCntSleep(creature.getSlept().getSleepDuration() - 1);
        if (creature.getSlept().getSleepDuration() <= 0){
            System.out.println(creature.getName() + " a besoin de dormir");
        }
        System.out.println(creature.getName() + " a besoin de dormir dans : " + creature.getSlept().getSleepDuration() + " tours");
    }

}

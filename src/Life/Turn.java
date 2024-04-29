package Life;
import java.util.*;

public class Turn {

    // Turn a besoins de a liste des créatures existant
    public Turn(List<Creature> creatures) {

        // Pour chaque créature faire l'itération suivante
        for (Creature creature : creatures) {
            // Appeller la function makeHungry avec comme paramètre la créature
            makeHungry(creature);
        }
    }

    public void makeHungry(Creature creature) {
        creature.getHungry().setEat(creature.getHungry().getEat()-1);
        if (creature.getHungry().getEat() == 0) {
            System.out.println(creature.getName() + " a faim");
        }
        System.out.println(creature.getName());
    }

}

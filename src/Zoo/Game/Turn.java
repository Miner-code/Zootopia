package Zoo.Game;

import java.util.List;
import Zoo.Creature.Creature;
import Zoo.Enclosure.Enclosure;

public class Turn {

    public Turn(List<Creature> creatures, Enclosure enclosure) {
        this.takeTurn(creatures, enclosure);
    }

    private void makeHungry(Creature creature) {
        creature.getHungry().setEat(creature.getHungry().getEat() - 1);
        if (creature.getHungry().getEat() == 0) {
            System.out.println(creature.getName() + " a faim");
        }
        System.out.println(creature.getName());
        System.out.println(creature.getHungry().getEat());
    }

    private void makeSlept(Creature creature) {
        creature.getSlept().setCntSleep(creature.getSlept().getCntSleep() - 1);
        if (creature.getSlept().getCntSleep() <= 0) {
            System.out.println(creature.getName() + " dort");
        } else if (creature.getSlept().getCntSleep() == creature.getSlept().getSleepDuration()) {
            System.out.println(creature.getName() + " se réveille");
        } else {
            System.out.println(creature.getName() + " a besoin de dormir dans : " + creature.getSlept().getCntSleep() + " tours");
        }
    }

    public void takeTurn(List<Creature> creatures, Enclosure enclosure) {
        for (Creature creature : creatures) {
            makeHungry(creature);
            makeSlept(creature);
        }
        enclosure.degradeCleanliness();
        enclosure.displayCharacteristics();
    }
}

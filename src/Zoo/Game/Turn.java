package Zoo.Game;

import java.util.List;
import Zoo.Creature.*;
import Zoo.Enclosure.Enclosure;

public class Turn {

    public Turn(List<Creature> creatures) {
        this.takeTurn(creatures);
    }





    public void takeTurn(List<Creature> creatures) {
        for (Creature creature : creatures) {
            Hungry.makeHungry(creature);
            Slept.makeSlept(creature);
            Health.getSick(creature);
        }
        System.out.println("Fin Tour");
        //enclosure.degradeCleanliness();
        //enclosure.levelUp();
        //enclosure.displayCharacteristics();
        //enclosure.addCreature("New Creature");
        //enclosure.removeCreature("Existing Creature");
        //enclosure.maintenance();
    }
}

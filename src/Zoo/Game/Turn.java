package Zoo.Game;

import java.util.List;
import Zoo.Creature.*;
import Zoo.Creature.Action.Health;
import Zoo.Creature.Action.Hungry;
import Zoo.Creature.Action.Slept;
import Zoo.Creature.Type.Type;

public class Turn {

    public Turn(List<Creature> creatures) {
        this.takeTurn(creatures);
    }





    public void takeTurn(List<Creature> creatures) {
        for (Creature creature : creatures) {
            Hungry.makeHungry(creature, creatures);
            Slept.makeSlept(creature);
            Health.getSick(creature, creatures);
            System.out.println(creature.getSpecies().getType().getTypeName());
            System.out.println(creature.getSpecies().getScpeciesName());
            Type.makeAction(creature);

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

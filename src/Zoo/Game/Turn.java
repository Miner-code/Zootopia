package Zoo.Game;

import java.util.List;

import IHM.UI.ZooGridElement.EnclosureIHM;
import Zoo.Creature.*;
import Zoo.Creature.Action.Health;
import Zoo.Creature.Action.Hungry;
import Zoo.Creature.Action.Slept;
import Zoo.Creature.Species.Kraken;
import Zoo.Creature.Type.Swimmer;
import Zoo.Creature.Type.Type;
import Zoo.Life.Life;

public class Turn {

    public Turn(List<Creature> creatures, List<EnclosureIHM> enclosureIHMS){
        this.takeTurn(creatures,enclosureIHMS);
    }





    public void takeTurn(List<Creature> creatures, List<EnclosureIHM> enclosureIHMS) {
        for (Creature creature : creatures) {
            Hungry.makeHungry(creature, creatures);
            Slept.makeSlept(creature);
            Health.getSick(creature, creatures);
            Type.makeAction(creature);
            Life.getOlder(creature,creatures);

        }
        for(EnclosureIHM enclosureIHM : enclosureIHMS) {
            enclosureIHM.getEnclosure().maintenance(enclosureIHM);
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

package Zoo.Game;

import java.util.ArrayList;
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

import static Zoo.Creature.Creature.die;

public class Turn {

    public Turn(List<Creature> creatures, List<EnclosureIHM> enclosureIHMS){
        this.takeTurn(creatures,enclosureIHMS);
    }

    public void takeTurn(List<Creature> creatures, List<EnclosureIHM> enclosureIHMs) {
        List<Creature> creaturesToRemove = new ArrayList<>();

        for (Creature creature : creatures) {
            Hungry.makeHungry(creature, creatures);
            Slept.makeSlept(creature);
            Health.getSick(creature, creatures);
            Type.makeAction(creature);
            Life.getOlder(creature, creatures);


            if (Creature.creatureShouldDie(creature)) {
                creaturesToRemove.add(creature);
            }
        }

        for (Creature creature : creaturesToRemove) {
            die(creature, creatures);
        }

        for (EnclosureIHM enclosureIHM : enclosureIHMs) {
            enclosureIHM.getEnclosure().maintenance(enclosureIHM);
        }

        System.out.println("\n\t \n\t \n\t \n\t \n\t \n\t \n\t \n\t \n\t \n\t \n\t \n\t \n\t \n\t \n\t \n\t \n\t \n\t \n\t \n\t ");
    }
}


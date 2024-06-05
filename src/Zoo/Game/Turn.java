package Zoo.Game;

import java.util.ArrayList;
import java.util.Iterator;
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


/**
 * The type Turn.
 */
public class Turn {

    /**
     * Instantiates a new Turn.
     *
     * @param creatures     the creatures
     * @param enclosureIHMS the enclosure ihms
     */

    public Turn(List<Creature> creatures, List<EnclosureIHM> enclosureIHMs) {
        this.takeTurn(creatures, enclosureIHMs);
    }

    /**
     * Take turn.
     *
     * @param creatures     the creatures
     * @param enclosureIHMs the enclosure ih ms
     */
    public void takeTurn(List<Creature> creatures, List<EnclosureIHM> enclosureIHMs) {

        System.out.println("\n\n\n\n\n\n\n\n\n\n\n---------------------------------------");
        System.out.println("Début du nouveau jour !");
        System.out.println("---------------------------------------\n\n");

        List<Creature> creaturesToRemove = new ArrayList<>();

        for (EnclosureIHM enclosureIHM : enclosureIHMs) {
            List<Creature> currentCreatures = new ArrayList<>(enclosureIHM.getEnclosure().getCreaturesPresent());

            for (Creature creature : currentCreatures) {
                enclosureIHM.getEnclosure().maintenance(enclosureIHM);

                if (creature.getName() != null) {
                    Hungry.makeHungry(creature, creatures, enclosureIHM);
                } else {
                    creaturesToRemove.add(creature);
                }

                if (creature.getName() != null) {
                    Slept.makeSlept(creature);
                }

                if (creature.getName() != null) {
                    Health.getSick(creature, creatures, enclosureIHM);
                } else {
                    creaturesToRemove.add(creature);
                }

                if (creature.getName() != null) {
                    Type.makeAction(creature);
                }

                if (creature.getName() != null) {
                    Life.getOlder(creature, creatures, enclosureIHM);
                } else {
                    creaturesToRemove.add(creature);
                }

                EnclosureIHM.addCreatureImgToEnclosure(enclosureIHMs);
            }

            enclosureIHM.getEnclosure().getCreaturesPresent().removeAll(creaturesToRemove);
        }

        creatures.removeAll(creaturesToRemove);


        System.out.println("\n\t \n\t \n\t \n\t \n\t \n\t \n\t \n\t \n\t \n\t \n\t \n\t \n\t \n\t \n\t \n\t \n\t \n\t \n\t \n\t ");

        EnclosureIHM.addCreatureImgToEnclosure(enclosureIHMs);

    }
}


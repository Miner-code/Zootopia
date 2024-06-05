import IHM.MainGamePanel;
import IHM.UI.ZooGridElement.EnclosureIHM;
import Zoo.Creature.Creature;
import Zoo.Creature.Action.Health;
import Zoo.Creature.Action.Hungry;
import Zoo.Creature.Action.Slept;
import Zoo.Creature.Species.*;

import java.util.ArrayList;
import java.util.List;


/**
 * The type Start.
 */
public class Start {
    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {

        List<Creature> arrayCreatures = new ArrayList<>();

        arrayCreatures.add(new Dragon("Loukas", true, 1, 10, 40, new Hungry(10), new Slept(5, 5), new Health(1)));
        arrayCreatures.add(new Unicorn("Draco", true, 1, 15, 500, new Hungry(7), new Slept(8, 6), new Health(100)));


        List<EnclosureIHM> arrayEnclosure = new ArrayList<>();

        new MainGamePanel(arrayCreatures,arrayEnclosure);

        EnclosureIHM.addCreatureImgToEnclosure(arrayEnclosure);

    }
}

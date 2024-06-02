import IHM.MainGamePanel;
import IHM.UI.ZooGridElement.EnclosureIHM;
import Zoo.Creature.Creature;
import Zoo.Creature.Action.Health;
import Zoo.Creature.Action.Hungry;
import Zoo.Creature.Action.Slept;
import Zoo.Creature.Species.*;

import java.util.ArrayList;
import java.util.List;


public class Start {
    public static void main(String[] args) {

        List<Creature> arrayCreatures = new ArrayList<>();

        arrayCreatures.add(new Dragon("Loukas", true, 1, 10, 40, new Hungry(10), new Slept(5, 5), new Health(1)));
        arrayCreatures.add(new Unicorn("Draco", true, 1, 15, 500, new Hungry(7), new Slept(8, 6), new Health(100)));
        arrayCreatures.add(new Mermaid("Mega", true, 1, 20, 30000, new Hungry(1), new Slept(6, 4), new Health(1)));

        List<EnclosureIHM> arrayEnclosure = new ArrayList<>();

        new MainGamePanel(arrayCreatures,arrayEnclosure);

        EnclosureIHM.addCreatureImgToEnclosure(arrayEnclosure);

    }
}

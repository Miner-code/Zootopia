package Zoo.Master;

import Zoo.Creature.Creature;
import Zoo.Enclosure.Enclosure;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Fantastic zoo.
 */
class FantasticZoo {
    /**
     * The Name.
     */
    String name;
    /**
     * The Fantastic zoo keeper.
     */
    FantasticZooKeeper fantasticZooKeeper;
    /**
     * The Max number of enclosures.
     */
    int maxNumberOfEnclosures;
    /**
     * The Existing enclosures.
     */
    List<Enclosure> existingEnclosures;

    /**
     * Instantiates a new Fantastic zoo.
     *
     * @param name                  the name
     * @param fantasticZooKeeper    the fantastic zoo keeper
     * @param maxNumberOfEnclosures the max number of enclosures
     */
    public FantasticZoo(String name, FantasticZooKeeper fantasticZooKeeper, int maxNumberOfEnclosures) {
        this.name = name;
        this.fantasticZooKeeper = fantasticZooKeeper;
        this.maxNumberOfEnclosures = maxNumberOfEnclosures;
        this.existingEnclosures = new ArrayList<>();
    }

   //oid displayTotalCreatureCount() {
   //   int totalCreatureCount = this.existingEnclosures.stream().mapToInt(enclosure -> enclosure.numberOfCreaturesPresent).sum();
   //   System.out.println("Total number of creatures in the zoo: " + totalCreatureCount);
   //

   //void displayEnclosureCreatures() {
   //    for (Enclosure enclosure : this.existingEnclosures) {
   //        enclosure.displayCharacteristics();
   //    }
   //}

   //void mainMethod() {
   //    for (Enclosure enclosure : this.existingEnclosures) {
   //        for (String creatureName : enclosure.creaturesPresent) {
   //            Creature creature = null; // Placeholder to get the creature object corresponding to creatureName
   //            // Randomly modify the state of the creature
   //            // Randomly modify the state of the enclosure
   //            // Call methods of the fantastic zookeeper based on the actions to perform
   //        }
   //    }
   //}
}

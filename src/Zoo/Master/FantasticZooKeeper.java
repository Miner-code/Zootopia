package Zoo.Master;

import Zoo.Creature.Creature;
import Zoo.Enclosure.Enclosure;

import java.util.ArrayList;
import java.util.List;

class FantasticZoo {
    String name;
    FantasticZooKeeper fantasticZooKeeper;
    int maxNumberOfEnclosures;
    List<Enclosure> existingEnclosures;

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

package Zoo.Master;

import Zoo.Creature.Creature;
import Zoo.Enclosure.Enclosure;

public class FantasticZooKeeper {
    String name;
    String sex;
    int age;

    public FantasticZooKeeper(String name, String sex, int age) {
        this.name = name;
        this.sex = sex;
        this.age = age;
    }

    void inspectEnclosure(Enclosure enclosure) {
        enclosure.displayCharacteristics();
    }

    void cleanEnclosure(Enclosure enclosure) {
        enclosure.cleanEnclosure();
    }

    void feedCreaturesInEnclosure(Enclosure enclosure) {
        enclosure.feedCreatures();
    }

    public void transferCreature(String creatureName, Enclosure sourceEnclosure, Enclosure destinationEnclosure) {
        Creature creatureToTransfer = null;
        for (Creature creature : sourceEnclosure.getCreatures()) {
            if (creature.getName().equals(creatureName)) {
                creatureToTransfer = creature;
                break;
            }
        }

        if (creatureToTransfer != null) {
            if (destinationEnclosure.getCreatures().isEmpty() || destinationEnclosure.getCreatures().get(0).getSpecies().equals(creatureToTransfer.getSpecies())) {
                if (sourceEnclosure.removeCreature(creatureName)) {
                    if (destinationEnclosure.addCreature(creatureToTransfer)) {
                        System.out.println(creatureToTransfer.getName() + " has been transferred from " + sourceEnclosure.getName() + " to " + destinationEnclosure.getName() + ".");
                    } else {
                        System.out.println("Failed to add " + creatureToTransfer.getName() + " to " + destinationEnclosure.getName() + ".");
                    }
                } else {
                    System.out.println("Failed to remove " + creatureToTransfer.getName() + " from " + sourceEnclosure.getName() + ".");
                }
            } else {
                System.out.println("Cannot transfer creature. Destination enclosure already has a different species.");
            }
        } else {
            System.out.println(creatureName + " is not in enclosure " + sourceEnclosure.getName() + ".");
        }
    }
}

package Zoo.Enclosure;

import Zoo.Creature.*;

import java.util.ArrayList;
import java.util.List;

public class Enclosure {
    public final String name;
    private final int size;
    private int level;
    private double cleanliness;
    private int maxCreatures;
    private final List<Creature> creatures;
    private final List<String> creaturesPresent;
    private int numberOfCreaturesPresent;

    public Enclosure(String name, int size) {
        this.name = name;
        this.size = size;
        this.level = 1;
        this.cleanliness = 100;
        this.creatures = new ArrayList<>();
        this.creaturesPresent = new ArrayList<>();
        this.maxCreatures = 1;
    }

    public String getName() {
        return this.name;
    }

    public List<Creature> getCreatures() {
        return this.creatures;
    }

    public int getNumberOfCreaturesPresent() {
        return creatures.size();
    }

    public void feedCreatures() {
        // Implémentez la logique pour nourrir les créatures ici
    }

    public List<String> getCreaturesPresent() {
        return creaturesPresent;
    }

    public void levelUp() {
        if (level < 3) {
            level++;
            maxCreatures++;
            System.out.println("Enclosure leveled up to level " + level + " with max capacity " + maxCreatures + "!");
        } else {
            System.out.println("Enclosure has reached the maximum level!");
        }
    }

    public void maintenance() {
        cleanliness -= 10;
        if (cleanliness <= 0) {
            cleanliness = 0;
            System.out.println("Enclosure needs cleaning!");
            cleanEnclosure();
        }
    }

    public void cleanEnclosure() {
        cleanliness = 100;
        System.out.println("Enclosure cleaned!");
    }

    public boolean addCreature(Creature creature) {
        if (creature instanceof Unicorn || creature instanceof Werewolf || creature instanceof Nymph || creature instanceof Dragon) {
            if (creatures.isEmpty() || creatures.get(0).getClass().equals(creature.getClass())) {
                if (creatures.size() < maxCreatures) {
                    creatures.add(creature);
                    creaturesPresent.add(creature.getName());
                    System.out.println(creature.getName() + " added to the enclosure!");
                    return true;
                } else {
                    System.out.println("Enclosure is full!");
                }
            } else {
                System.out.println("Cannot add creature. Enclosure already has a different species.");
            }
        } else {
            System.out.println("This type of creature cannot be added to this enclosure.");
        }
        return false;
    }

    public boolean removeCreature(String creatureName) {
        for (Creature creature : creatures) {
            if (creature.getName().equals(creatureName)) {
                creatures.remove(creature);
                creaturesPresent.remove(creatureName);
                System.out.println(creatureName + " removed from the enclosure!");
                return true;
            }
        }
        System.out.println(creatureName + " not found in the enclosure!");
        return false;
    }

    public void displayCharacteristics() {
        System.out.println("Enclosure: " + name);
        System.out.println("Size: " + size);
        System.out.println("Level: " + level);
        System.out.println("Cleanliness: " + cleanliness + "%");
        System.out.println("Max Creatures: " + maxCreatures);
        System.out.println("Current Creatures:");
        for (Creature creature : creatures) {
            System.out.println("- " + creature.getName());
        }
    }

    public void degradeCleanliness() {
        cleanliness -= 10;
        if (cleanliness <= 0) {
            cleanliness = 0;
            System.out.println("Enclosure needs cleaning!");
        }
    }
}

package Zoo.Enclosure;

import Zoo.Creature.Creature;
import Zoo.Creature.Unicorn;
import Zoo.Creature.Werewolf;
import Zoo.Creature.Nymph;
import Zoo.Creature.Dragon;

import java.util.ArrayList;
import java.util.List;

public class Enclosure {
    public String name;
    double area;
    int maxNumberOfCreatures;
    public int numberOfCreaturesPresent;
    public List<Creature> creatures;
    double cleanliness;
    int level;

    public Enclosure(String name, double area) {
        this.name = name;
        this.area = area;
        this.maxNumberOfCreatures = 1;
        this.numberOfCreaturesPresent = 0;
        this.creatures = new ArrayList<>();
        this.cleanliness = 100; // Initialiser la propreté à 100
        this.level = 1;
        int turnsSinceLastClean = 0;
    }

    public String getName() {
        return this.name;
    }

    public List<Creature> getCreatures() {
        return this.creatures;
    }

    public int getNumberOfCreaturesPresent() {
        return this.numberOfCreaturesPresent;
    }

    public List<String> getCreaturesPresent() {
        List<String> creatureNames = new ArrayList<>();
        for (Creature creature : creatures) {
            creatureNames.add(creature.getName());
        }
        return creatureNames;
    }

    public void displayCharacteristics() {
        System.out.println("Enclosure: " + this.name);
        System.out.println("Area: " + this.area);
        System.out.println("Maximum number of creatures: " + this.maxNumberOfCreatures);
        System.out.println("Number of creatures present: " + this.numberOfCreaturesPresent);
        System.out.println("Creatures present: ");
        for (Creature creature : creatures) {
            System.out.println(creature.getName());
        }
        System.out.println("Cleanliness: " + this.cleanliness + "%");
    }

    public boolean addCreature(Creature creature) {
        if (creature instanceof Unicorn || creature instanceof Werewolf || creature instanceof Nymph || creature instanceof Dragon) {
            if (creatures.isEmpty() || creatures.get(0).getClass().equals(creature.getClass())) {
                if (creatures.size() < maxNumberOfCreatures) {
                    creatures.add(creature);
                    numberOfCreaturesPresent++;
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
                numberOfCreaturesPresent--;
                System.out.println(creatureName + " has been removed from enclosure " + this.name + ".");
                return true;
            }
        }
        System.out.println(creatureName + " is not in this enclosure.");
        return false;
    }

    public void feedCreatures() {
        for (Creature creature : creatures) {
            System.out.println(creature.getName() + " has been fed.");
        }
    }

    public void degradeCleanliness() {
        cleanliness -= 10;
        if (cleanliness < 0) {
            cleanliness = 0;
        }
        System.out.println("Enclosure " + this.name + " cleanliness degraded to " + cleanliness + "%.");
    }

    public void maintenance() {
        cleanliness = 100; // Réinitialiser la propreté à 100 lors du nettoyage
        System.out.println("Enclosure " + this.name + " has been cleaned. Cleanliness is now 100%.");
    }

    public void levelUp() {
        if (this.level < 3) {
            this.maxNumberOfCreatures++;
            this.level++;
            System.out.println("Enclosure " + this.name + " has leveled up to level " + this.level + ".");
        } else {
            System.out.println("Enclosure " + this.name + " is already at maximum level.");
        }
    }
}

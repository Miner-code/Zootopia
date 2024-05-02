package Zoo.Enclosure;

import java.util.ArrayList;
import java.util.List;

public class Enclosure {
    public String name;
    double area;
    int maxNumberOfCreatures;
    public int numberOfCreaturesPresent;
    public List<String> creaturesPresent;
    String cleanlinessDegree;
    int level;

    public Enclosure(String name, double area, int maxNumberOfCreatures) {
        this.name = name;
        this.area = area;
        this.maxNumberOfCreatures = maxNumberOfCreatures;
        this.numberOfCreaturesPresent = 0;
        this.creaturesPresent = new ArrayList<>();
        this.cleanlinessDegree = "correct";
        this.level = 1;
    }

    public void displayCharacteristics() {
        System.out.println("Enclosure: " + this.name);
        System.out.println("Area: " + this.area);
        System.out.println("Maximum number of creatures: " + this.maxNumberOfCreatures);
        System.out.println("Number of creatures present: " + this.numberOfCreaturesPresent);
        System.out.println("Creatures present: " + String.join(", ", this.creaturesPresent));
        System.out.println("Cleanliness degree: " + this.cleanlinessDegree);
    }

    public void addCreature(String creatureName) {
        if (this.numberOfCreaturesPresent < this.maxNumberOfCreatures) {
            this.creaturesPresent.add(creatureName);
            this.numberOfCreaturesPresent++;
            System.out.println(creatureName + " has been added to enclosure " + this.name + ".");
        } else {
            System.out.println("The enclosure is full, you cannot add more creatures.");
        }
    }

    public void removeCreature(String creatureName) {
        if (this.creaturesPresent.contains(creatureName)) {
            this.creaturesPresent.remove(creatureName);
            this.numberOfCreaturesPresent--;
            System.out.println(creatureName + " has been removed from enclosure " + this.name + ".");
        } else {
            System.out.println(creatureName + " is not in this enclosure.");
        }
    }

    public void feedCreatures() {
        for (String creatureName : this.creaturesPresent) {
            System.out.println(creatureName + " has been fed.");
        }
    }

    public void maintenance() {
        if (this.cleanlinessDegree.equals("poor")) {
            this.cleanlinessDegree = "correct";
            System.out.println("Enclosure " + this.name + " has been cleaned.");
        } else if (this.cleanlinessDegree.equals("correct")) {
            this.cleanlinessDegree = "good";
            System.out.println("Enclosure " + this.name + " has been well cleaned.");
        } else {
            System.out.println("Enclosure " + this.name + " is already clean.");
        }
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

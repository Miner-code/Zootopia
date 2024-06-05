package Zoo.Enclosure;

import IHM.UI.ZooGridElement.EnclosureIHM;
import Zoo.Creature.*;

import java.util.ArrayList;
import java.util.List;
import java.util.SequencedCollection;
import java.util.stream.Collectors;


public class Enclosure {
    private String name;
    private final int size;
    private int level;
    private double cleanliness;
    private int maxCreatures;
    private final List<Creature> creatures;
    private final List<Creature> creaturesPresent;
    private int numberOfCreaturesPresent;

    public Enclosure(String name, String type) {
        this.name = name;
        this.size = 50;
        this.level = 1;
        this.cleanliness = 100;
        this.creatures = new ArrayList<>();
        this.creaturesPresent = new ArrayList<>();
        this.maxCreatures = 1;
        this.numberOfCreaturesPresent = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSize() {
        return size;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public double getCleanliness() {
        return cleanliness;
    }

    public void setCleanliness(double cleanliness) {
        this.cleanliness = cleanliness;
    }

    public int getMaxCreatures() {
        return maxCreatures;
    }

    public void setMaxCreatures(int maxCreatures) {
        this.maxCreatures = maxCreatures;
    }


    public String toString() {
        return "Enclosure{" +
                "name='" + name + '\'' +
                ", size=" + size +
                ", level=" + level +
                ", cleanliness=" + cleanliness +
                ", maxCreatures=" + maxCreatures +
                ", creatures=" + creatures +
                ", creaturesPresent=" + creaturesPresent +
                ", numberOfCreaturesPresent=" + numberOfCreaturesPresent +
                '}';
    }

    public List<Creature> getCreatures() {
        return this.creatures;
    }

    public List<Creature> getCreaturesPresent() {
        return creaturesPresent;
    }

    public void displayCharacteristics() {
        System.out.println("Enclos : " + this.name);
        System.out.println("Créature présent : " + creaturesPresent.size() + " / " + maxCreatures);
        System.out.println("Cleanliness: " + this.cleanliness + "%");
    }

    public static void levelUp(Enclosure enclosure) {
        if (enclosure.getLevel() < 3) {
            enclosure.setLevel(enclosure.getLevel() + 1);
            enclosure.setMaxCreatures(enclosure.getMaxCreatures() + 1);
            System.out.println("L'enclos pas au level " + enclosure.getLevel() + " et augmente sa capacité à " + enclosure.getMaxCreatures() + "!");
        } else {
            System.out.println("L'enclos est au niveau maximal");
        }
    }

    public void maintenance(EnclosureIHM enclosureIHMS) {
        cleanliness -= 10;
        if (cleanliness <= 0) {
            cleanliness = 0;
            System.out.println(enclosureIHMS.getEnclosure().getName() + " à besoin d'être nettoyé");
        }
    }

    public boolean removeCreature(Creature creature) {
        if (creature != null) {
            creaturesPresent.remove(creature);
            return true;
        }


        return false;
    }


    public static void cleanEnclosure(Enclosure enclosure) {
        enclosure.setCleanliness(100);
        System.out.println(enclosure.getName() + " est nettoyé ");
    }


    public static void makeTransfer(Creature creature, Enclosure enclosureSource, Enclosure enclosureDestination) {
        // Si l'enclos source n'est pas null cela veux dire que on fais un transfert d'un enclos a vers b
        if (enclosureSource != null) {
            enclosureSource.removeCreature(creature);
            enclosureDestination.getCreaturesPresent().add(creature);
        }// Si l'enclos est null alors on ajoute juste une créature a l'enclos de destination
        else {
            enclosureDestination.getCreaturesPresent().add(creature);
        }
    }

    public static List<Enclosure> enclosuresWithFreeSpace(List<EnclosureIHM> enclosureIHMs, String type) {

        List<Enclosure> enclosureWithFreeSpace = new ArrayList<>();
        for (EnclosureIHM enclosureIHM : enclosureIHMs) {

            if (enclosureIHM.getEnclosure().getCreaturesPresent().size() != enclosureIHM.getEnclosure().getMaxCreatures()) {
                if (enclosureIHM.getEnclosure().getClass().getSimpleName().equalsIgnoreCase(type)) {

                    enclosureWithFreeSpace.add(enclosureIHM.getEnclosure());
                }
            }
        }
        return enclosureWithFreeSpace;
    }
}

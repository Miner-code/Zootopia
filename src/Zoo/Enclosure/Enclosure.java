package Zoo.Enclosure;

import IHM.UI.ZooGridElement.EnclosureIHM;
import Zoo.Creature.*;

import java.util.ArrayList;
import java.util.List;


/**
 * The type Enclosure.
 */
public class Enclosure {
    private String name;
    private final int size;
    private int level;
    private double cleanliness;
    private int maxCreatures;
    private final List<Creature> creatures;
    private final List<Creature> creaturesPresent;
    private int numberOfCreaturesPresent;

    /**
     * Instantiates a new Enclosure.
     *
     * @param name the name
     * @param type the type
     */
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

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets size.
     *
     * @return the size
     */
    public int getSize() {
        return size;
    }

    /**
     * Gets level.
     *
     * @return the level
     */
    public int getLevel() {
        return level;
    }

    /**
     * Sets level.
     *
     * @param level the level
     */
    public void setLevel(int level) {
        this.level = level;
    }

    /**
     * Gets cleanliness.
     *
     * @return the cleanliness
     */
    public double getCleanliness() {
        return cleanliness;
    }

    /**
     * Sets cleanliness.
     *
     * @param cleanliness the cleanliness
     */
    public void setCleanliness(double cleanliness) {
        this.cleanliness = cleanliness;
    }

    /**
     * Gets max creatures.
     *
     * @return the max creatures
     */
    public int getMaxCreatures() {
        return maxCreatures;
    }

    /**
     * Sets max creatures.
     *
     * @param maxCreatures the max creatures
     */
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

    /**
     * Gets creatures.
     *
     * @return the creatures
     */
    public List<Creature> getCreatures() {
        return this.creatures;
    }

    /**
     * Gets creatures present.
     *
     * @return the creatures present
     */
    public List<Creature> getCreaturesPresent() {
        return creaturesPresent;
    }

    /**
     * Display characteristics.
     */
    public void displayCharacteristics() {
        System.out.println("Enclos : " + this.name);
        System.out.println("Créature présent : " + creaturesPresent.size() +" / " + maxCreatures  );
        System.out.println("Cleanliness: " + this.cleanliness + "%");
    }

    /**
     * Level up.
     *
     * @param enclosure the enclosure
     */
    public static void levelUp(Enclosure enclosure) {
        if (enclosure.getLevel() < 3) {
            enclosure.setLevel(enclosure.getLevel()+1);
            enclosure.setMaxCreatures(enclosure.getMaxCreatures()+1);
            System.out.println("L'enclos pas au level " + enclosure.getLevel() + " et augmente sa capacité à " + enclosure.getMaxCreatures() + "!");
        } else {
            System.out.println("L'enclos est au niveau maximal");
        }
    }

    /**
     * Maintenance.
     *
     * @param enclosureIHMS the enclosure ihms
     */
    public void maintenance(EnclosureIHM enclosureIHMS) {
        cleanliness -= 10;
        if (cleanliness <= 0) {
            cleanliness = 0;
            System.out.println(enclosureIHMS.getEnclosure().getName() + " à besoin d'être nettoyé");
        }
    }

    /**
     * Remove creature boolean.
     *
     * @param creature the creature
     * @return the boolean
     */
    public boolean removeCreature(Creature creature) {
        if (creature != null){
            creaturesPresent.remove(creature);
            return true;
        }


        return false;
    }


    /**
     * Clean enclosure.
     *
     * @param enclosure the enclosure
     */
    public static  void cleanEnclosure(Enclosure enclosure) {
        enclosure.setCleanliness(100);
        System.out.println(enclosure.getName() + " est nettoyé ");
    }


    /**
     * Make transfer.
     *
     * @param creature             the creature
     * @param enclosureIHMSource   the enclosure ihm source
     * @param enclosureDestination the enclosure destination
     */
    public static void makeTransfer(Creature creature, EnclosureIHM enclosureIHMSource,Enclosure enclosureDestination){
        // Si l'enclos source n'est pas null cela veux dire que on fais un transfert d'un enclos a vers b
        if (enclosureIHMSource != null){
            enclosureIHMSource.getEnclosure().removeCreature(creature);
            enclosureDestination.getCreaturesPresent().add(creature);
        }// Si l'enclos est null alors on ajoute juste une créature a l'enclos de destination
        else{
            enclosureDestination.getCreaturesPresent().add(creature);
        }
    }

    /**
     * Enclosures with free space list.
     *
     * @param enclosureIHMs the enclosure ih ms
     * @param type          the type
     * @return the list
     */
    public static List<Enclosure> enclosuresWithFreeSpace(List<EnclosureIHM> enclosureIHMs,String type) {

        List<Enclosure> enclosureWithFreeSpace = new ArrayList<>();
        for (EnclosureIHM enclosureIHM : enclosureIHMs) {

            if(enclosureIHM.getEnclosure().getCreaturesPresent().size() != enclosureIHM.getEnclosure().getMaxCreatures()){
                if (enclosureIHM.getEnclosure().getClass().getSimpleName().equalsIgnoreCase(type)){

                    enclosureWithFreeSpace.add(enclosureIHM.getEnclosure());
                }
            }
        }
        return enclosureWithFreeSpace;
    }

}

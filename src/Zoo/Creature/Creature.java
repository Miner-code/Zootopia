package Zoo.Creature;
import IHM.UI.ZooGridElement.EnclosureIHM;
import Zoo.Creature.Action.Health;
import Zoo.Creature.Action.Hungry;
import Zoo.Creature.Action.Slept;
import Zoo.Creature.Species.*;
import Zoo.Creature.Type.Type;
import Zoo.Enclosure.Enclosure;
import Zoo.Life.Life;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import static Zoo.Widget.Widget.RandomNumberGenerator.generateRandomBoolean;
import static Zoo.Widget.Widget.RandomNumberGenerator.generateRandomNumber;

/**
 * The type Creature.
 */
public abstract  class Creature extends Life  {
    /**
     * The Size.
     */
    public double size;
    /**
     * The Weight.
     */
    public double weight;
    /**
     * The Hungry.
     */
    public Hungry hungry;
    /**
     * The Slept.
     */
    public Slept slept;
    /**
     * The Health.
     */
    public Health health;

    /**
     * Instantiates a new Creature.
     *
     * @param name    the name
     * @param sex     the sex
     * @param age     the age
     * @param species the species
     * @param size    the size
     * @param weight  the weight
     * @param hungry  the hungry
     * @param slept   the slept
     * @param health  the health
     */
    public Creature(String name, boolean sex, double age, String species, double size, double weight, Hungry hungry, Slept slept, Health health) {
        super(name, sex, age, species);
        this.size = size;
        this.weight = weight;
        this.hungry = hungry;
        this.slept = slept;
        this.health = health;
    }

    /**
     * Gets type.
     *
     * @return the type
     */
    public abstract Type getType();

    /**
     * Gets hungry.
     *
     * @return the hungry
     */
    public Hungry getHungry() {
        return hungry;
    }

    /**
     * Gets slept.
     *
     * @return the slept
     */
    public Slept getSlept() {
        return slept;
    }

    /**
     * Gets health.
     *
     * @return the health
     */
    public Health getHealth() {
        return health;
    }


    /**
     * Gets size.
     *
     * @return the size
     */
    public double getSize() {
        return size;
    }

    /**
     * Gets weight.
     *
     * @return the weight
     */
    public double getWeight() {
        return weight;
    }

    /**
     * Gets species.
     *
     * @return the species
     */
    public String getSpecies() {
        return species;
    }

    /**
     * Sets size.
     *
     * @param size the size
     */
    public void setSize(double size) {
        this.size = size;
    }

    /**
     * Sets weight.
     *
     * @param weight the weight
     */
    public void setWeight(double weight) {
        this.weight = weight;
    }



    @Override
    protected void scream() {

    }

    @Override
    protected void gettingOld() {

    }

    @Override
    protected void sleeping() {

    }

    @Override
    public String toString() {
        return
                "\n\tsize=" + size +
                ", \n\tweight=" + weight +
                ", \n\thungry=" + hungry +
                ", \n\tslept=" + slept +
                ", \n\thealth=" + health +
                ", \n\tspecies=" + species +
                ", \n\tage=" + age +
                ", \n\tsex=" + sex +
                ", \n\tname='" + name + '\''
                ;
    }


    /**
     * Die.
     *
     * @param creature  the creature
     * @param creatures the creatures
     */
    public static void die(Creature creature, List<Creature> creatures) {
        System.out.println("La créature " + creature.getName() + " est morte");
        String speciesCreature = creature.getSpecies().toLowerCase();

        if (speciesCreature.equals("dragon") || speciesCreature.equals("phoenix") || speciesCreature.equals("nymph")) {
            creature.setAge(0);
            creature.getHealth().setHealth(5);
            System.out.println("La créature " + creature.getName() + " renait");
        } else {
            creatures.remove(creature);
        }
    }

    /**
     * Creature should die boolean.
     *
     * @param creature the creature
     * @return the boolean
     */
    public static boolean creatureShouldDie(Creature creature) {
        return creature.getHealth().isCritical();
    }


    /**
     * Add creature.
     *
     * @param name          the name
     * @param species       the species
     * @param creatures     the creatures
     * @param enclosure     the enclosure
     * @param enclosureIHMS the enclosure ihms
     */
    public static void addCreature(String name,String species, List<Creature> creatures, Enclosure enclosure,List<EnclosureIHM> enclosureIHMS){
        Creature newCreature = null;
        switch (species.toLowerCase()) {
            case "unicorn" -> newCreature = new Unicorn(name, generateRandomBoolean(), 1, generateRandomNumber(1,5), generateRandomNumber(15,150),new Hungry((int) generateRandomNumber(4,10)), new Slept((int) generateRandomNumber(4,10), (int) generateRandomNumber(4,10)), new Health((int) generateRandomNumber(5,12)));
            case "werewolf" -> newCreature = new Werewolf(name, generateRandomBoolean(), 1, generateRandomNumber(1,5), generateRandomNumber(15,150), new Hungry((int) generateRandomNumber(4,10)), new Slept((int) generateRandomNumber(4,10), (int) generateRandomNumber(4,10)), new Health((int) generateRandomNumber(5,12)));
            case "nymph" -> newCreature = new Nymph(name, generateRandomBoolean(), 1, generateRandomNumber(1,5), generateRandomNumber(15,150), new Hungry((int) generateRandomNumber(4,10)), new Slept((int) generateRandomNumber(4,10), (int) generateRandomNumber(4,10)), new Health((int) generateRandomNumber(5,12)));
            case "dragon" -> newCreature = new Dragon(name, generateRandomBoolean(), 1, generateRandomNumber(1,5), generateRandomNumber(15,150), new Hungry((int) generateRandomNumber(4,10)), new Slept((int) generateRandomNumber(4,10), (int) generateRandomNumber(4,10)), new Health((int) generateRandomNumber(5,12)));
            case "phoenix" -> newCreature = new Phoenix(name, generateRandomBoolean(), 1, generateRandomNumber(1,5), generateRandomNumber(15,150), new Hungry((int) generateRandomNumber(4,10)), new Slept((int) generateRandomNumber(4,10), (int) generateRandomNumber(4,10)), new Health((int) generateRandomNumber(5,12)));
            case "megalodon" -> newCreature = new Megalodon(name, generateRandomBoolean(), 1, generateRandomNumber(1,5), generateRandomNumber(15,150), new Hungry((int) generateRandomNumber(4,10)), new Slept((int) generateRandomNumber(4,10), (int) generateRandomNumber(4,10)), new Health((int) generateRandomNumber(5,12)));
            case "kraken" -> newCreature = new Kraken(name, generateRandomBoolean(), 1, generateRandomNumber(1,5), generateRandomNumber(15,150), new Hungry((int) generateRandomNumber(4,10)), new Slept((int) generateRandomNumber(4,10), (int) generateRandomNumber(4,10)), new Health((int) generateRandomNumber(5,12)));
            case "mermaid" -> newCreature = new Mermaid(name, generateRandomBoolean(), 1, generateRandomNumber(1,5), generateRandomNumber(15,150), new Hungry((int) generateRandomNumber(4,10)), new Slept((int) generateRandomNumber(4,10), (int) generateRandomNumber(4,10)), new Health((int) generateRandomNumber(5,12)));
            default -> System.out.println("L'espèce n'existe pas.");
        }

        if (newCreature != null) {
            System.out.println(newCreature.getName() + " a bien été ajouté");
            creatures.add(newCreature);
            Enclosure.makeTransfer(newCreature, null, enclosure);


            EnclosureIHM.addCreatureImgToEnclosure(enclosureIHMS);

        } else {
            System.out.println("Un problème est survenu à la création de la créature");
        }


    }


}

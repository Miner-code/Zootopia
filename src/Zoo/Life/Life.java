package Zoo.Life;

import Zoo.Creature.Creature;
import Zoo.Creature.Species.Species;

import java.util.List;

/**
 * The type Life.
 */
public abstract class Life {
    /**
     * The Name.
     */
    public String name;
    /**
     * The Sex.
     */
    public boolean sex;
    /**
     * The Age.
     */
    public double age;
    /**
     * The Species.
     */
    public String species;

    /**
     * Instantiates a new Life.
     *
     * @param name    the name
     * @param sex     the sex
     * @param age     the age
     * @param species the species
     */
    public Life(String name, boolean sex, double age, String species) {
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.species = species;
    }

    /**
     * Scream.
     */
    protected abstract void scream();

    /**
     * Gets old.
     */
    protected abstract void gettingOld();

    /**
     * Sleeping.
     */
    protected abstract void sleeping();

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }


    /**
     * Is sex boolean.
     *
     * @return the boolean
     */
    public boolean isSex() {
        return sex;
    }

    /**
     * Gets age.
     *
     * @return the age
     */
    public double getAge() {
        return age;
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
     * Sets age.
     *
     * @param age the age
     */
    public void setAge(double age) {
        this.age = age;
    }

    /**
     * Sets sex.
     *
     * @param sex the sex
     */
    public void setSex(boolean sex) {
        this.sex = sex;
    }


    /**
     * Get older.
     *
     * @param creature  the creature
     * @param creatures the creatures
     */
    public static void getOlder(Creature creature, List<Creature> creatures){
        if(creature.getName() != null){
            creature.setAge(creature.getAge()+0.25);
            double chanceOfDying = ((creature.getAge() * creature.getAge()) / 10);
            double number = Math.random();
            if ((number * 100) < chanceOfDying) {
                Creature.die(creature,creatures);
            }
        }
    }

}

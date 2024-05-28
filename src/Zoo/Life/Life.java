package Zoo.Life;

import Zoo.Creature.Action.Health;
import Zoo.Creature.Creature;
import Zoo.Creature.Species.Species;

import java.util.List;

public abstract class Life {
    public String name;
    public boolean sex;
    public double age;
    public Species species;

    public Life(String name, boolean sex, double age, Species species) {
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.species = species;
    }

    protected abstract void scream();
    protected abstract void gettingOld();
    protected abstract void sleeping();

    public String getName() {
        return name;
    }


    public boolean isSex() {
        return sex;
    }

    public double getAge() {
        return age;
    }

    public Species getSpecies() {
        return species;
    }

    public void setName(String name) {
        this.name = name;
    }


    public void setAge(double age) {
        this.age = age;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }


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

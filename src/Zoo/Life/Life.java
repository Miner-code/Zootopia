package Zoo.Life;

import Zoo.Creature.Action.Health;
import Zoo.Creature.Species.Species;

public abstract class Life {
    public String name;
    public boolean sex;
    public int age;
    public Species species;

    public Life(String name, boolean sex, int age, Species species) {
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

    public int getAge() {
        return age;
    }

    public Species getSpecies() {
        return species;
    }

    public void setName(String name) {
        this.name = name;
    }


    public void setAge(int age) {
        this.age = age;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

}

package Life;

import Life.Hungry;

public class Creature extends Life  {
    public double size;
    public boolean health;
    public double weight;
    public Hungry hungry;

    public Creature(String name, boolean sex, int age, String species, double size, boolean health, double weight) {
        super(name, sex, age, species);
        this.size = size;
        this.health = health;
        this.weight = weight;
        this.hungry = new Hungry(4);
    }

    public Hungry getHungry() {
        return hungry;
    }

    public double getSize() {
        return size;
    }

    public double getWeight() {
        return weight;
    }

    public boolean isHealth() {
        return health;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setHealth(boolean health) {
        this.health = health;
    }


    public Hungry setHungry(String Hungry) {
        return hungry;
    }

}

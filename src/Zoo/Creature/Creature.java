package Zoo.Creature;
import Zoo.Life.Life;

public class Creature extends Life  {
    public double size;
    public boolean health;
    public double weight;
    public Hungry hungry;
    public Slept slept;

    public Creature(String name, boolean sex, int age, String species, double size, boolean health, double weight) {
        super(name, sex, age, species);
        this.size = size;
        this.health = health;
        this.weight = weight;
        this.hungry = new Hungry(1);
        this.slept = new Slept(3,3);
    }

    public Hungry getHungry() {
        return hungry;
    }

    public Slept getSlept() {
        return slept;
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

    @Override
    protected void scream() {

    }

    @Override
    protected void gettingOld() {

    }

    @Override
    protected void sleeping() {

    }


    public Slept setSlept(String Slept) {
        return slept;
    }

    public Hungry setHungry(String Hungry) {
        return hungry;
    }

}

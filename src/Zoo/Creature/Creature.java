package Zoo.Creature;
import Zoo.Life.Life;

public class Creature extends Life  {
    public double size;
    public double weight;
    public Hungry hungry;
    public Slept slept;
    public Health health;

    public Creature(String name, boolean sex, int age, String species, double size,double weight, Hungry hungry,Slept slept, Health health) {
        super(name, sex, age, species);
        this.size = size;
        this.weight = weight;
        this.hungry = hungry;
        this.slept = slept;
        this.health = health;
    }

    public Hungry getHungry() {
        return hungry;
    }

    public Slept getSlept() {
        return slept;
    }

    public Health getHealth() {
        return health;
    }

    public double getSize() {
        return size;
    }

    public double getWeight() {
        return weight;
    }



    public void setSize(double size) {
        this.size = size;
    }

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


    public Slept setSlept(String Slept) {
        return slept;
    }

    public Hungry setHungry(String Hungry) {
        return hungry;
    }

}
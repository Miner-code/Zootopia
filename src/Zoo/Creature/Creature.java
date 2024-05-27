package Zoo.Creature;
import Zoo.Creature.Action.Health;
import Zoo.Creature.Action.Hungry;
import Zoo.Creature.Action.Slept;
import Zoo.Creature.Species.Dragon;
import Zoo.Creature.Species.Species;
import Zoo.Creature.Type.Type;
import Zoo.Life.Life;

import java.util.List;

public class Creature extends Life  {
    public double size;
    public double weight;
    public Hungry hungry;
    public Slept slept;
    public Health health;

    public Creature(String name, boolean sex, int age, Species species, double size, double weight, Hungry hungry, Slept slept, Health health) {
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

    public static void die(Creature creature, List<Creature> creatures) {
        System.out.println("La créature " + creature.getName() + " est morte" );
        creatures.remove(creature);
    }

}
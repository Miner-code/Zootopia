package Life;

abstract class Creature {
    public double size;
    public boolean hungry;
    public boolean health;
    public double weight;

    public Creature(double size, boolean hungry, boolean health, double weight) {
        this.size = size;
        this.hungry = hungry;
        this.health = health;
        this.weight = weight;
    }

    public void eat(String name){
        this.hungry = true;
        System.out.println(name + " a mangé");
    }
    public void needEat(String name){
        this.hungry = false;
        System.out.println(name + " BESOIN MANGER !!!!");
    }
    abstract void cure();

    public double getSize() {
        return size;
    }

    public double getWeight() {
        return weight;
    }

    public boolean isHealth() {
        return health;
    }

    public boolean isHungry() {
        return hungry;
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

    public void setHungry(boolean hungry) {
        this.hungry = hungry;
    }
}

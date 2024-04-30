package Zoo.Life;

public abstract class Life {
    public String name;
    public boolean sex;
    public int age;
    public String species;

    public Life(String name, boolean sex, int age, String species) {
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.species = species;
    }

    protected abstract void scream();
    protected abstract void gettingOld();
    protected abstract void sleeping();
}

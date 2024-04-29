package Zoo.Life;

abstract class Life {
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

    abstract void scream();
    abstract void gettingOld();
    abstract void sleeping();
}

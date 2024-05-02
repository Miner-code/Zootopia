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

    public String getName() {
        return name;
    }

    public String getSpecies() {
        return species;
    }

    public boolean isSex() {
        return sex;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

}

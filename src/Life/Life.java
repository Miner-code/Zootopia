package Life;

abstract class Life {
    public String name;
    public boolean sex;
    public int age;
    public String species;

    public Life (String name, boolean sex, int age, String species) {
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.species = species;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getSpecies() {
        return species;
    }

    public int getAge() {
        return age;
    }

    public boolean isSex() {
        return sex;
    }
//abstract void scream();
    //abstract void gettingOld();
    //abstract void sleeping();

}

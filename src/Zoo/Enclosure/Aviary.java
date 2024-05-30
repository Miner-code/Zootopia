package Zoo.Enclosure;

public class Aviary extends Zoo.Enclosure.Enclosure {
    double height;

    public Aviary(String name, int maxNumberOfCreatures, double height) {
        super(name);
        this.height = height;
    }

    //@Override
    //public void displayCharacteristics() {
    //    super.displayCharacteristics();
    //    System.out.println("Height: " + this.height);
    //}
}

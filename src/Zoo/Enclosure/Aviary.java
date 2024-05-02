package Zoo.Enclosure;

public class Aviary extends Zoo.Enclosure.Enclosure {
    double height;

    public Aviary(String name, double area, int maxNumberOfCreatures, double height) {
        super(name, area, maxNumberOfCreatures);
        this.height = height;
    }

    @Override
    public void displayCharacteristics() {
        super.displayCharacteristics();
        System.out.println("Height: " + this.height);
    }
}

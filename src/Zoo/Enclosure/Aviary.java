package Zoo.Enclosure;

public class Aviary extends Zoo.Enclosure.Enclosure {
    int height;

    public Aviary(String name, int height) {
        super(name,"aviary");
        this.height = height;
    }

    @Override
    public void displayCharacteristics() {
        super.displayCharacteristics();
        System.out.println("Hauteur: " + this.height);
    }

}

package Zoo.Enclosure;

/**
 * The type Aviary.
 */
public class Aviary extends Zoo.Enclosure.Enclosure {
    /**
     * The Height.
     */
    int height;

    /**
     * Instantiates a new Aviary.
     *
     * @param name   the name
     * @param height the height
     */
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

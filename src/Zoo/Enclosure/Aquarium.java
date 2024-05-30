package Zoo.Enclosure;

public class Aquarium extends Zoo.Enclosure.Enclosure {
    double basinDepth;
    double waterSalinity;

    public Aquarium(String name,  int maxNumberOfCreatures, double basinDepth, double waterSalinity) {
        super(name);
        this.basinDepth = basinDepth;
        this.waterSalinity = waterSalinity;
    }

    //@Override
    //public void displayCharacteristics() {
    //    super.displayCharacteristics();
    //    System.out.println("Profondeur du bassin : " + this.basinDepth);
    //    System.out.println("Salinité de l'eau : " + this.waterSalinity);
    //}
}

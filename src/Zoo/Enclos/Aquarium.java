package Zoo.Enclos;

public class Aquarium extends Enclos {
    double profondeurDuBassin;
    double saliniteDeLEau;

    public Aquarium(String nom, double superficie, int nombreMaxCreatures, double profondeurDuBassin, double saliniteDeLEau) {
        super(nom, superficie, nombreMaxCreatures);
        this.profondeurDuBassin = profondeurDuBassin;
        this.saliniteDeLEau = saliniteDeLEau;
    }

    @Override
    public void afficherCaracteristiques() {
        super.afficherCaracteristiques();
        System.out.println("Profondeur du bassin : " + this.profondeurDuBassin);
        System.out.println("Salinité de l'eau : " + this.saliniteDeLEau);
    }
}

package Zoo.Enclos;

public class Voliere extends Enclos {
    double hauteur;

    public Voliere(String nom, double superficie, int nombreMaxCreatures, double hauteur) {
        super(nom, superficie, nombreMaxCreatures);
        this.hauteur = hauteur;
    }

    @Override
    public void afficherCaracteristiques() {
        super.afficherCaracteristiques();
        System.out.println("Hauteur : " + this.hauteur);
    }
}


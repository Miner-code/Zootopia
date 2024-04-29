package Life;

class Volant extends Creature {
    Volant(String nom, String sexe, double poids, double taille, int age) {
        super(nom, sexe, poids, taille, age);
    }

    void voler() {
        System.out.println(this.nom + " vole.");
    }
}

package Life;

class Marin extends Creature {
    Marin(String nom, String sexe, double poids, double taille, int age) {
        super(nom, sexe, poids, taille, age);
    }

    void nager() {
        System.out.println(this.nom + " nage.");
    }
}

package Life;

class Terrestre extends Creature {
    Terrestre(String nom, String sexe, double poids, double taille, int age) {
        super(nom, sexe, poids, taille, age);
    }

    void courir() {
        System.out.println(this.nom + " court.");
    }
}
package Life;

class Vivipare extends Creature {
    Vivipare(String nom, String sexe, double poids, double taille, int age) {
        super(nom, sexe, poids, taille, age);
    }

    void mettreBas() {
        if (this.sexe.equals("Femelle")) {
            System.out.println(this.nom + " a mis bas.");
        } else {
            System.out.println("Les mâles ne peuvent pas mettre bas.");
        }
    }
}

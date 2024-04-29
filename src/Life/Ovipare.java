package Life;

class Ovipare extends Creature {
    Ovipare(String nom, String sexe, double poids, double taille, int age) {
        super(nom, sexe, poids, taille, age);
    }

    void pondreDesOeufs() {
        if (this.sexe.equals("Femelle")) {
            System.out.println(this.nom + " a pondu des œufs.");
        } else {
            System.out.println("Les mâles ne peuvent pas pondre des œufs.");
        }
    }
}


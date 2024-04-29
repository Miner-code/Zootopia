package Zoo.Creature.Birth;

import Zoo.Creature.Creature;

class Rebirth extends Creature {
    Rebirth(String nom, String sexe, double poids, double taille, int age) {
        super(nom, sexe, poids, taille, age);
    }

    void renaitre() {
        System.out.println(this.nom + " est ramené à la vie.");
    }
}

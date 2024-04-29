package Zoo.Master;

import Zoo.Enclos.Enclos;

class MaitreDeZooFantastique {
    String nom;
    String sexe;
    int age;

    public MaitreDeZooFantastique(String nom, String sexe, int age) {
        this.nom = nom;
        this.sexe = sexe;
        this.age = age;
    }

    void examinerEnclos(Enclos enclos) {
        enclos.afficherCaracteristiques();
    }

    void nettoyerEnclos(Enclos enclos) {
        enclos.entretien();
    }

    void nourrirCreaturesEnclos(Enclos enclos) {
        enclos.nourrirCreatures();
    }

    void transfererCreature(String creatureNom, Enclos enclosSource, Enclos enclosDestination) {
        if (enclosSource.creaturesPresentes.contains(creatureNom)) {
            enclosSource.enleverCreature(creatureNom);
            enclosDestination.ajouterCreature(creatureNom);
            System.out.println(creatureNom + " a été transféré de " + enclosSource.nom + " à " + enclosDestination.nom + ".");
        } else {
            System.out.println(creatureNom + " n'est pas dans l'enclos " + enclosSource.nom + ".");
        }
    }
}

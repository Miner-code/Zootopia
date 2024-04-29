package Zoo.Master;

import Zoo.Creature.Creature;
import Zoo.Enclos.Enclos;

import java.util.ArrayList;
import java.util.List;

class ZooFantastique {
    String nom;
    MaitreDeZooFantastique maitreDeZooFantastique;
    int nombreMaxEnclos;
    List<Enclos> enclosExistants;

    public ZooFantastique(String nom, MaitreDeZooFantastique maitreDeZooFantastique, int nombreMaxEnclos) {
        this.nom = nom;
        this.maitreDeZooFantastique = maitreDeZooFantastique;
        this.nombreMaxEnclos = nombreMaxEnclos;
        this.enclosExistants = new ArrayList<>();
    }

    void afficherNombreCreatures() {
        int nombreTotalCreatures = this.enclosExistants.stream().mapToInt(enclos -> enclos.nombreCreaturesPresentes).sum();
        System.out.println("Nombre total de créatures dans le zoo : " + nombreTotalCreatures);
    }

    void afficherCreaturesEnclos() {
        for (Enclos enclos : this.enclosExistants) {
            enclos.afficherCaracteristiques();
        }
    }

    void methodePrincipale() {
        for (Enclos enclos : this.enclosExistants) {
            for (String creatureNom : enclos.creaturesPresentes) {
                Creature creature = null; // Placeholder pour obtenir l'objet créature correspondant à creatureNom
                // Modifier aléatoirement l'état de la créature
                // Modifier aléatoirement l'état de l'enclos
                // Appeler les méthodes du maître de zoo fantastique selon les actions à effectuer
            }
        }
    }
}

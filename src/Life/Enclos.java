package Life;

import java.util.ArrayList;
import java.util.List;

class Enclos {
    String nom;
    double superficie;
    int nombreMaxCreatures;
    int nombreCreaturesPresentes;
    List<String> creaturesPresentes;
    String degreDeProprete;

    public Enclos(String nom, double superficie, int nombreMaxCreatures) {
        this.nom = nom;
        this.superficie = superficie;
        this.nombreMaxCreatures = nombreMaxCreatures;
        this.nombreCreaturesPresentes = 0;
        this.creaturesPresentes = new ArrayList<>();
        this.degreDeProprete = "correct";
    }

    void afficherCaracteristiques() {
        System.out.println("Enclos : " + this.nom);
        System.out.println("Superficie : " + this.superficie);
        System.out.println("Nombre maximum de créatures : " + this.nombreMaxCreatures);
        System.out.println("Nombre de créatures présentes : " + this.nombreCreaturesPresentes);
        System.out.println("Créatures présentes : " + String.join(", ", this.creaturesPresentes));
        System.out.println("Degré de propreté : " + this.degreDeProprete);
    }

    void ajouterCreature(String creatureNom) {
        if (this.nombreCreaturesPresentes < this.nombreMaxCreatures) {
            this.creaturesPresentes.add(creatureNom);
            this.nombreCreaturesPresentes++;
            System.out.println(creatureNom + " a été ajouté à l'enclos " + this.nom + ".");
        } else {
            System.out.println("L'enclos est plein, vous ne pouvez pas ajouter de nouvelle créature.");
        }
    }

    void enleverCreature(String creatureNom) {
        if (this.creaturesPresentes.contains(creatureNom)) {
            this.creaturesPresentes.remove(creatureNom);
            this.nombreCreaturesPresentes--;
            System.out.println(creatureNom + " a été enlevé de l'enclos " + this.nom + ".");
        } else {
            System.out.println(creatureNom + " n'est pas dans cet enclos.");
        }
    }

    void nourrirCreatures() {
        for (String creatureNom : this.creaturesPresentes) {
            System.out.println(creatureNom + " a été nourri.");
        }
    }

    void entretien() {
        if (this.degreDeProprete.equals("mauvais")) {
            this.degreDeProprete = "correct";
            System.out.println("L'enclos " + this.nom + " a été nettoyé.");
        } else if (this.degreDeProprete.equals("correct")) {
            this.degreDeProprete = "bon";
            System.out.println("L'enclos " + this.nom + " a été bien nettoyé.");
        } else {
            System.out.println("L'enclos " + this.nom + " est déjà propre.");
        }
    }
}
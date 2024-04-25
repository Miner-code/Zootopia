package Zootopia;

import java.util.ArrayList;

// Enumération pour le degré de propreté
enum Proprete {
    MAUVAIS, CORRECT, BON
}

// Classe abstraite Enclos
abstract class Enclos {
    protected String nom;
    protected double superficie;
    protected int capaciteMax;
    protected int nombreDeCreatures;
    protected ArrayList<Creature> creatures;
    protected Proprete proprete;

    public Enclos(String nom, double superficie, int capaciteMax) {
        this.nom = nom;
        this.superficie = superficie;
        this.capaciteMax = capaciteMax;
        this.nombreDeCreatures = 0;
        this.creatures = new ArrayList<>();
        this.proprete = Proprete.BON;
    }

    public abstract void afficherCaracteristiques();

    public void ajouterCreature(Creature creature) {
        if (this.nombreDeCreatures < this.capaciteMax && creature.getClass() == getClasseCreature()) {
            this.creatures.add(creature);
            this.nombreDeCreatures++;
            System.out.println("La créature a été ajoutée à l'enclos.");
        } else {
            System.out.println("Impossible d'ajouter la créature à cet enclos.");
        }
    }

    public void enleverCreature(Creature creature) {
        if (this.creatures.remove(creature)) {
            this.nombreDeCreatures--;
            System.out.println("La créature a été enlevée de l'enclos.");
        } else {
            System.out.println("La créature n'était pas présente dans cet enclos.");
        }
    }

    public void nourrirCreatures() {
        for (Creature creature : this.creatures) {
            creature.manger();
        }
        System.out.println("Les créatures ont été nourries.");
    }

    public void entretenir() {
        System.out.println("L'enclos a été nettoyé et entretenu.");
        this.proprete = Proprete.BON;
    }

    protected abstract Class<? extends Creature> getClasseCreature();
}

// Classe EnclosStandard
class EnclosStandard extends Enclos {
    public EnclosStandard(String nom, double superficie, int capaciteMax) {
        super(nom, superficie, capaciteMax);
    }

    @Override
    public void afficherCaracteristiques() {
        System.out.println("Enclos standard : " + nom);
        System.out.println("Superficie : " + superficie + " m²");
        System.out.println("Capacité max : " + capaciteMax);
        System.out.println("Nombre de créatures : " + nombreDeCreatures);
        System.out.println("Propreté : " + proprete);
    }

    @Override
    protected Class<? extends Creature> getClasseCreature() {
        return Creature.class;
    }
}

// Classe Voliere
class Voliere extends Enclos {
    private double hauteur;

    public Voliere(String nom, double superficie, int capaciteMax, double hauteur) {
        super(nom, superficie, capaciteMax);
        this.hauteur = hauteur;
    }

    @Override
    public void afficherCaracteristiques() {
        System.out.println("Volière : " + nom);
        System.out.println("Superficie : " + superficie + " m²");
        System.out.println("Capacité max : " + capaciteMax);
        System.out.println("Nombre de créatures : " + nombreDeCreatures);
        System.out.println("Propreté : " + proprete);
        System.out.println("Hauteur : " + hauteur + " m");
    }

    @Override
    protected Class<? extends Creature> getClasseCreature() {
        return CreatureVolante.class;
    }
}

// Classe Aquarium
class Aquarium extends Enclos {
    private final double profondeur;
    private final double salinite;

    public Aquarium(String nom, double superficie, int capaciteMax, double profondeur, double salinite) {
        super(nom, superficie, capaciteMax);
        this.profondeur = profondeur;
        this.salinite = salinite;
    }

    @Override
    public void afficherCaracteristiques() {
        System.out.println("Aquarium : " + nom);
        System.out.println("Superficie : " + superficie + " m²");
        System.out.println("Capacité max : " + capaciteMax);
        System.out.println("Nombre de créatures : " + nombreDeCreatures);
        System.out.println("Propreté : " + proprete);
        System.out.println("Profondeur : " + profondeur + " m");
        System.out.println("Salinité de l'eau : " + salinite);
    }

    @Override
    protected Class<? extends Creature> getClasseCreature() {
        return CreatureAquatique.class;
    }
}

// Exemple de classe CreatureVolante
class CreatureVolante extends Creature {
    // Implémentation de la classe CreatureVolante
}

// Exemple de classe CreatureAquatiqur
class CreatureAquatique extends Creature {
    // Implémentation de la classe CreatureAquatiqur
}

// Exemple de classe Creature
class Creature {
    // Implémentation de la classe Creature
}

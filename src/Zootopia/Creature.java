package Zootopia;

// Création de l'énumération pour le sexe
enum Sexe {
    MALE, FEMELLE
}

// Classe abstraite Creature
abstract class Creature {
    protected String nom;
    protected Sexe sexe;
    protected double poids;
    protected double taille;
    protected int age;
    protected boolean estAffame;
    protected boolean dort;
    protected boolean enVie;

    public Creature(String nom, Sexe sexe, double poids, double taille, int age) {
        this.nom = nom;
        this.sexe = sexe;
        this.poids = poids;
        this.taille = taille;
        this.age = age;
        this.estAffame = false;
        this.dort = false;
        this.enVie = true;
    }

    public abstract void manger();
    public abstract void emettreSon();
    public abstract void soigner();
    public abstract void dormir();
    public abstract void reveiller();
    public abstract void vieillir();
}

// Interface pour les créatures qui peuvent se déplacer
interface Deplacable {
    void seDeplacer();
}

// Interface pour les créatures vivipares
interface Vivipare {
    void mettreBas();
}

// Interface pour les créatures ovipares
interface Ovipare {
    void pondreOeuf();
}

// Classe Licorne
class Licorne extends Creature implements Deplacable, Vivipare {
    public Licorne(String nom, Sexe sexe, double poids, double taille, int age) {
        super(nom, sexe, poids, taille, age);
    }

    @Override
    public void manger() {
        System.out.println("La licorne mange.");
    }

    @Override
    public void emettreSon() {
        System.out.println("La licorne émet un son.");
    }

    @Override
    public void soigner() {
        System.out.println("La licorne est soignée.");
    }

    @Override
    public void dormir() {
        System.out.println("La licorne s'endort.");
        this.dort = true;
    }

    @Override
    public void reveiller() {
        System.out.println("La licorne se réveille.");
        this.dort = false;
    }

    @Override
    public void vieillir() {
        this.age++;
        if (this.age >= 100) {
            System.out.println("La licorne est décédée de vieillesse.");
            this.enVie = false;
        }
    }

    @Override
    public void seDeplacer() {
        System.out.println("La licorne court.");
    }

    @Override
    public void mettreBas() {
        if (this.sexe == Sexe.FEMELLE) {
            System.out.println("La licorne met bas.");
        } else {
            System.out.println("Les licornes mâles ne peuvent pas mettre bas.");
        }
    }
}

// Ajoutez les autres classes pour les autres créatures en suivant le même modèle



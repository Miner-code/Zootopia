package Zoo.Creature;

import Zoo.Life.*;

public class Creature extends Life {
    public String nom;
    protected String sexe;
    double poids;
    double taille;
    int age;
    int indicateurFaim;
    boolean indicateurSommeil;
    int indicateurSante;

    public Creature(String nom, String sexe, double poids, double taille, int age) {
        super("", false, 0, "");
        this.nom = nom;
        this.sexe = sexe;
        this.poids = poids;
        this.taille = taille;
        this.age = age;
        this.indicateurFaim = 50;
        this.indicateurSommeil = false;
        this.indicateurSante = 100;
    }

    void manger() {
        if (!this.indicateurSommeil) {
            this.indicateurFaim -= 10;
            System.out.println(this.nom + " mange.");
        } else {
            System.out.println(this.nom + " est endormi, il ne peut pas manger.");
        }
    }

    void emettreUnSon() {
        System.out.println(this.nom + " émet un son.");
    }

    void etreSoigne() {
        this.indicateurSante = 100;
        System.out.println(this.nom + " a été soigné.");
    }

    void sEndormir() {
        this.indicateurSommeil = true;
        System.out.println(this.nom + " s'endort.");
    }

    void seReveiller() {
        this.indicateurSommeil = false;
        System.out.println(this.nom + " se réveille.");
    }

    void vieillir() {
        this.age++;
        System.out.println(this.nom + " vieillit d'une année.");
        if (this.age >= 10) {
            System.out.println(this.nom + " est mort de vieillesse.");
        }
    }

    void mourir() {
        System.out.println(this.nom + " est mort.");
    }

    @Override
    protected void scream() {

    }

    @Override
    protected void gettingOld() {

    }

    @Override
    protected void sleeping() {

    }
}
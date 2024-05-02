package Zoo.Creature;
import Zoo.Life.Life;

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
        this.hungry = new Hungry(1);
        this.slept = new Slept(3, 3);
    }

    public Hungry getHungry() {
        return hungry;
    }

    public Slept getSlept() {
        return slept;
    }

    public double getSize() {
        return taille; // Utilisation de "taille" au lieu de "size"
    }

    public double getWeight() {
        return poids; // Utilisation de "poids" au lieu de "weight"
    }

    public boolean isHealth() {
        return indicateurSante > 0; // Utilisation de "indicateurSante" pour vérifier la santé
    }

    public void setSize(double size) {
        this.taille = size; // Utilisation de "taille" au lieu de "size"
    }

    public void setWeight(double weight) {
        this.poids = weight; // Utilisation de "poids" au lieu de "weight"
    }

    public void setHealth(boolean health) {
        this.indicateurSante = health ? 100 : 0; // Mise à jour de l'indicateur de santé
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

    public Slept setSlept(String Slept) {
        return slept;
    }

    public Hungry setHungry(String Hungry) {
        return hungry;
    }

}

package Zootopia;

public class MainCreature {
    public static void main(String[] args) {
        // Exemple d'utilisation
        Licorne licorne = new Licorne("Licorne", Sexe.FEMELLE, 200, 2, 5);
        licorne.manger();
        licorne.emettreSon();
        licorne.soigner();
        licorne.dormir();
        licorne.reveiller();
        licorne.vieillir();
        licorne.seDeplacer();
        licorne.mettreBas();
    }
}

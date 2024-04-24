package Zootopia;

public class MainZookeeper {
    public static void main(String[] args) {
        // Création du maître de zoo fantastique
        MaitreDeZooFantastique maitreDeZoo = new MaitreDeZooFantastique("John", Sexe.MALE, 35);

        // Création des enclos
        EnclosStandard enclos1 = new EnclosStandard("Enclos 1", 100, 5);
        Voliere voliere1 = new Voliere("Volière 1", 50, 3, 10);
        Aquarium aquarium1 = new Aquarium("Aquarium 1", 200, 10, 5, 30);

        // Ajout des enclos à la liste du maître de zoo
        maitreDeZoo.enclos.add(enclos1);
        maitreDeZoo.enclos.add(voliere1);
        maitreDeZoo.enclos.add(aquarium1);

        // Affichage du menu du maître de zoo fantastique
        maitreDeZoo.afficherMenu();
    }
}

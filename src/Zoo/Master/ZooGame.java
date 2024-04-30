// ZooGame.java
//package Zoo.Master;
//
//
//import Zoo.Creature.*;
//import Zoo.Creature.Birth.Ovipare;
//import Zoo.Creature.Birth.Vivipare;
//import Zoo.Creature.Type.Marin;
//import Zoo.Creature.Type.Terrestre;
//import Zoo.Creature.Type.Volant;
//import Zoo.Enclos.*;
//
//public class ZooGame {
//    public static void main(String[] args) {
//        // Création du maître de zoo fantastique
//        MaitreDeZooFantastique maitreDeZoo = new MaitreDeZooFantastique("John", "Masculin", 35);
//
//        // Création du zoo fantastique
//        ZooFantastique zooFantastique = new ZooFantastique("Mon Zoo Fantastique", maitreDeZoo, 10);
//
//        // Création des enclos
//        Enclos enclos1 = new Enclos("Enclos 1", 100, 5);
//        Enclos enclos2 = new Enclos("Enclos 2", 150, 3);
//        Voliere voliere1 = new Voliere("Volière 1", 80, 2, 10);
//        Aquarium aquarium1 = new Aquarium("Aquarium 1", 200, 8, 20, 35);
//
//        // Ajout des enclos au zoo
//        zooFantastique.enclosExistants.add(enclos1);
//        zooFantastique.enclosExistants.add(enclos2);
//        zooFantastique.enclosExistants.add(voliere1);
//        zooFantastique.enclosExistants.add(aquarium1);
//
//        // Création des créatures
//        Vivipare licorne = new Vivipare("Licorne", "Femelle", 200, 2.5, 5);
//        Vivipare lycanthrope = new Vivipare("Lycanthrope", "Mâle", 150, 2, 8);
//        Ovipare dragon = new Ovipare("Dragon", "Mâle", 1000, 10, 15);
//        Terrestre phenix = new Terrestre("Phénix", "Femelle", 20, 1, 3);
//        Marin kraken = new Marin("Kraken", "Mâle", 500, 8, 12);
//        Volant sirene = new Volant("Sirène", "Femelle", 60, 1.5, 6);
//
//        // Ajout des créatures aux enclos
//        enclos1.ajouterCreature(licorne.nom);
//        enclos1.ajouterCreature(lycanthrope.nom);
//        enclos2.ajouterCreature(dragon.nom);
//        voliere1.ajouterCreature(phenix.nom);
//        aquarium1.ajouterCreature(kraken.nom);
//        aquarium1.ajouterCreature(sirene.nom);
//
//        // Affichage du nombre total de créatures dans le zoo
//        zooFantastique.afficherNombreCreatures();
//
//        // Affichage des caractéristiques des enclos et de leurs créatures
//        zooFantastique.afficherCreaturesEnclos();
//
//        // Exemple d'actions du maître de zoo fantastique
//        maitreDeZoo.examinerEnclos(enclos1);
//        maitreDeZoo.nettoyerEnclos(enclos1);
//        maitreDeZoo.nourrirCreaturesEnclos(enclos1);
//        maitreDeZoo.transfererCreature(lycanthrope.nom, enclos1, enclos2);
//    }
//}
//
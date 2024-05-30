package Zoo.Enclosure;

import IHM.UI.ZooGridElement.EnclosureIHM;
import Zoo.Creature.*;
import Zoo.Creature.Species.*;


import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Enclosure {
    private String name;
    private final int size;
    private int level;
    private double cleanliness;
    private int maxCreatures;
    private final List<Creature> creatures;
    private final List<Creature> creaturesPresent;
    private int numberOfCreaturesPresent;

    public Enclosure(String name) {
        this.name = name;
        this.size = 50;
        this.level = 1;
        this.cleanliness = 100;
        this.creatures = new ArrayList<>();
        this.creaturesPresent = new ArrayList<>();
        this.maxCreatures = 1;
        this.numberOfCreaturesPresent = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSize() {
        return size;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public double getCleanliness() {
        return cleanliness;
    }

    public void setCleanliness(double cleanliness) {
        this.cleanliness = cleanliness;
    }

    public int getMaxCreatures() {
        return maxCreatures;
    }

    public void setMaxCreatures(int maxCreatures) {
        this.maxCreatures = maxCreatures;
    }
    public int getNumberOfCreaturesPresent() {
        return numberOfCreaturesPresent;
    }
    public void setNumberOfCreaturesPresent(int numberOfCreaturesPresent) {
        this.numberOfCreaturesPresent = numberOfCreaturesPresent;
    }

    public String toString() {
        return "Enclosure{" +
                "name='" + name + '\'' +
                ", size=" + size +
                ", level=" + level +
                ", cleanliness=" + cleanliness +
                ", maxCreatures=" + maxCreatures +
                ", creatures=" + creatures +
                ", creaturesPresent=" + creaturesPresent +
                ", numberOfCreaturesPresent=" + numberOfCreaturesPresent +
                '}';
    }

    public List<Creature> getCreatures() {
        return this.creatures;
    }



    public void feedCreatures() {
        // Implémentez la logique pour nourrir les créatures ici
    }

    public List<Creature> getCreaturesPresent() {
        return creaturesPresent;
    }

    public void levelUp() {
        if (level < 3) {
            level++;
            maxCreatures++;
            System.out.println("Enclosure leveled up to level " + level + " with max capacity " + maxCreatures + "!");
        } else {
            System.out.println("Enclosure has reached the maximum level!");
        }
    }

    public void maintenance(EnclosureIHM enclosureIHMS) {
        cleanliness -= 10;
        if (cleanliness <= 0) {
            cleanliness = 0;
            System.out.println(enclosureIHMS.getEnclosure().getName() + " à besoin d'être nettoyé");
        }
    }


    public static void seeEnclosure(List<EnclosureIHM> enclosureIHMS,Scanner scanner){
        EnclosureIHM selectEnclosure = searchEnclosure(enclosureIHMS,scanner,"Voici le enclos","Rechercher l'enclos");

        if (selectEnclosure != null) {
            System.out.println(selectEnclosure.getEnclosure().toString());
            String action = scanner.nextLine();
            switch (action){
                case "c" -> {
                    System.out.println("vous êtes sortie des options d'enclos");
                }
                case "transfert" ->{
                    transfer(selectEnclosure,scanner,enclosureIHMS);
                }
                case "clean" -> {
                    cleanEnclosure(selectEnclosure);
                }
                default -> {
                    System.out.println("vous êtes sortie des options d'enclos");
                }
            }
        }
    }




    public static EnclosureIHM searchEnclosure(List<EnclosureIHM> enclosureIHMS, Scanner scanner, String message1, String message2){
        System.out.println(message1);
        for (EnclosureIHM enclosureIHM : enclosureIHMS) {
            System.out.println(enclosureIHM.getEnclosure().getName());
        }

        // Permettre à l'utilisateur de choisir quelle enclos sélectionner
        System.out.print(message2);

        String enclosureName = scanner.nextLine();//scanner.nextLine()
        System.out.println(enclosureName);

        // Chercher l'enclos dans la liste des enclos
        EnclosureIHM selectedEnclosure = null;
        for (EnclosureIHM enclosureIHM : enclosureIHMS) {
            System.out.println(enclosureIHM.getEnclosure().getName());
            if (enclosureIHM.getEnclosure().getName().equalsIgnoreCase(enclosureName)) {
                selectedEnclosure = enclosureIHM;
                break;
                // Arrêter la recherche dès que l'enclos est trouvée
            }
        }
        if (selectedEnclosure != null) {
            return selectedEnclosure;
        } else {
            System.out.println("Aucun enclos trouvée avec le nom spécifié");
            return null;
        }
    }
    public static EnclosureIHM searchEnclosureWithFreeSpace(List<EnclosureIHM> enclosureIHMS,Scanner scanner){
        // Créer une list pour stocker les enclos avec un espace
        List<EnclosureIHM> enclosureWithFreeSpaces = new ArrayList<>();
        System.out.println("Voici la liste des enclos avec de l'espace pour une y ajouter une créature");
        // Afficher les enclos avec de l'espace disponible
        for (EnclosureIHM enclosureIHM : enclosureIHMS) {
            // Si un enclos a un espace de libre
            if(enclosureIHM.getEnclosure().getCreaturesPresent().size() < enclosureIHM.getEnclosure().getMaxCreatures()){
                // Ajouter un enclos la liste
                enclosureWithFreeSpaces.add(enclosureIHM);
                // affiché l'eclos avec un espace de libre
                System.out.println(enclosureIHM.getEnclosure().getName());
            }
        }
        System.out.println("Entré l'enclos que vous voulez");
        String enclosureName = scanner.nextLine();

        for (EnclosureIHM enclosureWithFreeSpace : enclosureWithFreeSpaces) {
            if(enclosureWithFreeSpace.getEnclosure().getName().equalsIgnoreCase(enclosureName)){
                return enclosureWithFreeSpace;
            }
        }
        return null;
    }


    public static void addCreatureToEnclosure(Creature creature, EnclosureIHM enclosureIHM)
    {   // Si il y a une place
        if (checkMaxEnclosure(enclosureIHM) == true){
            // Ajouter la créature a l'enclos sélectioné
            enclosureIHM.getEnclosure().getCreaturesPresent().add(creature);
            // Mettre un message pour dire que la créature a bien été ajouté
            System.out.println(creature.getName() + " a bien été ajouté a l'enclos " + enclosureIHM.getEnclosure().getName());
            // Ajouter une
        }// Si non affiché un message pour dire qu'il n'y a plus de place
        else{
            System.out.println("Il n'y pas assez de place");
        }
    }


    public boolean removeCreature(Creature creature) {
        if (creature != null){
            creaturesPresent.remove(creature);
            return true;
        }


        return false;
    }

    public static boolean checkMaxEnclosure(EnclosureIHM enclosureIHM){
        // Vérifier si il y a une place dans l'encos
        if (enclosureIHM.getEnclosure().getCreaturesPresent().size()< enclosureIHM.getEnclosure().getMaxCreatures()) {
            // Si oui return true
            return true;
        }else{
            // Si non return false
            return false;
        }
    }
    public static  void cleanEnclosure(EnclosureIHM enclosureIHM) {
        enclosureIHM.getEnclosure().setCleanliness(100);
        System.out.println(enclosureIHM.getEnclosure().getName() + " est nettoyé ");
    }
    public static void transfer(EnclosureIHM enclosureIHM,Scanner scanner,List<EnclosureIHM> enclosureIHMS){
        // Créer une liste pour stocker les créatures présente dans l'enclos
        List<Creature> creaturePresent = enclosureIHM.getEnclosure().getCreaturesPresent();

        Creature creatureSelected = Creature.searchCreature(creaturePresent,scanner,"Choisir une créature dans l'enclos","Entrez le nom de la créature à déplacer");
        EnclosureIHM enclosureIHMSelected = Enclosure.searchEnclosureWithFreeSpace(enclosureIHMS,scanner);
        makeTransfer(creatureSelected,enclosureIHM,enclosureIHMSelected);
    }

    public static void makeTransfer(Creature creature, EnclosureIHM enclosureIHMSource,EnclosureIHM enclosureIHMDestination){
        enclosureIHMSource.getEnclosure().removeCreature(creature);
        enclosureIHMDestination.getEnclosure().getCreaturesPresent().add(creature);
    }
}

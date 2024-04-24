package Zootopia;

import java.util.Scanner;
import java.util.ArrayList;

// Enumération pour le sexe
enum Sexe {
    MALE, FEMELLE
}

// Classe Maître de Zoo Fantastique
class MaitreDeZooFantastique {
    private String nom;
    private Sexe sexe;
    private int age;
    private ArrayList<Enclos> enclos;

    public MaitreDeZooFantastique(String nom, Sexe sexe, int age) {
        this.nom = nom;
        this.sexe = sexe;
        this.age = age;
        this.enclos = new ArrayList<>();
    }

    // Méthode pour examiner un enclos
    public void examinerEnclos(Enclos enclos) {
        enclos.afficherCaracteristiques();
    }

    // Méthode pour nettoyer un enclos
    public void nettoyerEnclos(Enclos enclos) {
        enclos.entretenir();
    }

    // Méthode pour nourrir les créatures d'un enclos
    public void nourrirCreatures(Enclos enclos) {
        enclos.nourrirCreatures();
    }

    // Méthode pour transférer une créature d'un enclos à un autre
    public void transfererCreature(Creature creature, Enclos enclosSource, Enclos enclosDestination) {
        enclosSource.enleverCreature(creature);
        enclosDestination.ajouterCreature(creature);
    }

    // Méthode pour afficher le menu
    public void afficherMenu() {
        Scanner scanner = new Scanner(System.in);
        int choix;
        do {
            System.out.println("\nMenu du Maître de Zoo Fantastique:");
            System.out.println("1. Examiner un enclos");
            System.out.println("2. Nettoyer un enclos");
            System.out.println("3. Nourrir les créatures d'un enclos");
            System.out.println("4. Transférer une créature d'un enclos à un autre");
            System.out.println("0. Quitter");
            System.out.print("Entrez votre choix : ");
            choix = scanner.nextInt();
            switch (choix) {
                case 1:
                    examinerEnclos();
                    break;
                case 2:
                    nettoyerEnclos();
                    break;
                case 3:
                    nourrirCreatures();
                    break;
                case 4:
                    transfererCreature();
                    break;
                case 0:
                    System.out.println("Merci d'avoir utilisé le Maître de Zoo Fantastique. Au revoir !");
                    break;
                default:
                    System.out.println("Choix invalide. Veuillez choisir une option valide.");
            }
        } while (choix != 0);
    }

    // Méthode pour examiner un enclos
    private void examinerEnclos() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Entrez le nom de l'enclos à examiner : ");
        String nomEnclos = scanner.nextLine();
        Enclos enclosExamine = trouverEnclosParNom(nomEnclos);
        if (enclosExamine != null) {
            examinerEnclos(enclosExamine);
        } else {
            System.out.println("Aucun enclos trouvé avec ce nom.");
        }
    }

    // Méthode pour nettoyer un enclos
    private void nettoyerEnclos() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Entrez le nom de l'enclos à nettoyer : ");
        String nomEnclos = scanner.nextLine();
        Enclos enclosANettoyer = trouverEnclosParNom(nomEnclos);
        if (enclosANettoyer != null) {
            nettoyerEnclos(enclosANettoyer);
        } else {
            System.out.println("Aucun enclos trouvé avec ce nom.");
        }
    }

    // Méthode pour nourrir les créatures d'un enclos
    private void nourrirCreatures() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Entrez le nom de l'enclos où vous souhaitez nourrir les créatures : ");
        String nomEnclos = scanner.nextLine();
        Enclos enclosANourrir = trouverEnclosParNom(nomEnclos);
        if (enclosANourrir != null) {
            nourrirCreatures(enclosANourrir);
        } else {
            System.out.println("Aucun enclos trouvé avec ce nom.");
        }
    }

    // Méthode pour transférer une créature d'un enclos à un autre
    private void transfererCreature() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Entrez le nom de l'enclos source : ");
        String nomEnclosSource = scanner.nextLine();
        System.out.print("Entrez le nom de l'enclos destination : ");
        String nomEnclosDestination = scanner.nextLine();
        Enclos enclosSource = trouverEnclosParNom(nomEnclosSource);
        Enclos enclosDestination = trouverEnclosParNom(nomEnclosDestination);
        if (enclosSource != null && enclosDestination != null) {
            System.out.print("Entrez le nom de la créature à transférer : ");
            String nomCreature = scanner.nextLine();
            Creature creature = trouverCreatureParNom(nomCreature, enclosSource);
            if (creature != null) {
                transfererCreature(creature, enclosSource, enclosDestination);
                System.out.println("La créature a été transférée avec succès.");
            } else {
                System.out.println("Aucune créature trouvée avec ce nom dans l'enclos source.");
            }
        } else {
            System.out.println("L'un des enclos spécifiés n'existe pas.");
        }
    }

    // Méthode pour trouver un enclos par son nom
    private Enclos trouverEnclosParNom(String nomEnclos) {
        for (Enclos enclos : enclos) {
            if (enclos.nom.equalsIgnoreCase(nomEnclos)) {
                return enclos;
            }
        }
        return null;
    }

    // Méthode pour trouver une créature par son nom dans un enclos donné
    private Creature trouverCreatureParNom(String nomCreature, Enclos enclos) {
        for (Creature creature : enclos.creatures) {
            if (creature.nom.equalsIgnoreCase(nomCreature)) {
                return creature;
            }
        }
        return null;
    }
}




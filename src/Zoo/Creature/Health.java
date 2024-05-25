package Zoo.Creature;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Health {

    public int health;

    public int sick;

    public Health(int health) {
        this.health = health;
        this.sick = 0;
    }

    public int getHealth() {
        return health;
    }

    public int getSick() { return sick; }

    public void setHealth(int eat) {
        this.health = eat;
    }

    public void setSick(int sick) { this.sick = sick; }

    public static void getSick(Creature creature) {
        // Si la créature est déjà malade elle ne peut pas retomber malade
        if (creature.getHealth().getSick() != 1){
            // Génération d'un nombre entre 0.0 et 1.0
            double number = Math.random();
            if (number < 0.9) {
                // Mettre la crature malade
                creature.getHealth().setSick(1);
                // Afficher que la créature est malade
                System.out.println("La créature " + creature.getName() + " est tombé malade");
            }
        }
    }

    public static void removeTheDisease(List<Creature> creatures,Scanner scanner) {
        // Stocker les créatures malade
        List<Creature> sickCreatures = new ArrayList<>();

        // Afficher les créatures malades
        System.out.println("Liste des créatures malades  :");
        for (Creature creature : creatures) {
            if(creature.getHealth().getSick() ==1){
                System.out.println(creature.getName());
                sickCreatures.add(creature);
            }
        }
        // Si il y a au moins une créature malade
        if(!sickCreatures.isEmpty()){
            // Permettre à l'utilisateur de choisir quelle créature à endormir
            System.out.print("Entrez le nom de la a guérir : ");
            String creatureName = scanner.nextLine();

            Creature selectedCreature = null;
            // Vérifier que la créature rentré est dans le tableau des créature malades
            for (Creature sickCreature : sickCreatures) {
                if (sickCreature.getName().equals(creatureName)) {
                    selectedCreature = sickCreature;
                    break;
                }else{
                    System.out.println("La créature " + creatureName + " n'existe pas !");
                }
            }
            if (selectedCreature != null) {
                // Soigner la créature
                selectedCreature.getHealth().setSick(0);
                System.out.println("La créature " + selectedCreature.getName() + " a été soigné ");
            }

        }else{
            System.out.print("Aucune créature n'est disponible ");
        }

    }
}

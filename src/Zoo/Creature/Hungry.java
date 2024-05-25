package Zoo.Creature;

import java.util.Scanner;
import java.util.List;

public class Hungry {
    public int eat ;


    public Hungry(int eat) {
        this.eat = eat;
    }

    public int isEat() {
        return eat;
    }

    public int getEat() {
        return eat;
    }

    public void setEat(int eat) {
        this.eat = eat;
    }

    public static void makeHungry(Creature creature) {
        creature.getHungry().setEat(creature.getHungry().getEat() - 1);
        if (creature.getHungry().getEat() == 0) {
            System.out.println(creature.getName() + " a faim");
        }
        System.out.println(creature.getName() + " a " + creature.getHungry().getEat() + " de nourriture ");
    }

    public static void eatCreature(List<Creature> creatures,   Scanner scanner) {
        // Afficher la liste des créatures existantes
        System.out.println("Liste des créatures disponibles :");
        for (Creature creature : creatures) {
            System.out.println(creature.getName());
        }

        // Permettre à l'utilisateur de choisir quelle créature nourrir
        System.out.print("Entrez le nom de la créature à nourrir : ");
        String creatureName = scanner.nextLine();

        // Chercher la créature dans la liste des créatures
        Creature selectedCreature = null;
        for (Creature creature : creatures) {
            if (creature.getName().equalsIgnoreCase(creatureName)) {
                selectedCreature = creature;
                // Arrêter la recherche dès que la créature est trouvée
                break;
            }
        }

        if (selectedCreature != null) {
            // Si une créature est trouvée, la nourrir
            selectedCreature.getHungry().setEat(selectedCreature.getHungry().getEat() + 4);
            System.out.println(selectedCreature.getName() + " a correctement été nourri");
        } else {
            // Si aucune créature n'est trouvée
            System.out.println("Aucune créature trouvée avec le nom spécifié");
        }
    }


}

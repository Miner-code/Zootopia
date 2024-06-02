package Zoo.Creature.Action;

import Zoo.Creature.Creature;

import java.util.Scanner;
import java.util.List;
import static Zoo.Creature.Action.Health.removeHP;

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

    @Override
    public String toString() {
        return "Hungry{" +
                "eat=" + eat +
                '}';
    }

    public static void makeHungry(Creature creature, List<Creature> creatures) {
        if (creature.getName() != null){
            creature.getHungry().setEat(creature.getHungry().getEat() - 1);
            if (creature.getHungry().getEat() <= 0) {
                System.out.println(creature.getName() + " a faim");
                removeHP(creature,creatures);
                return;
            }
            //System.out.println(creature.getName() + " a " + creature.getHungry().getEat() + " de nourriture ");
        }

    }

    public static void eatCreature(List<Creature> creatures,   Scanner scanner) {
        Creature selectedCreature = Creature.searchCreature(creatures,scanner,"Liste des créatures disponibles :","Entrez le nom de la créature à nourrir : ");
        if (selectedCreature != null) {
            // Si une créature est trouvée, la nourrir
            eat(selectedCreature);
        } else {
            // Si aucune créature n'est trouvée
            System.out.println("Aucune créature trouvée avec le nom spécifié");
        }
    }
    public static void eat(Creature creature){
        if (creature.getName() != null){
            creature.getHungry().setEat(creature.getHungry().getEat() + 4);
            System.out.println(creature.getName() + " a correctement été nourri");
        }
    }

}

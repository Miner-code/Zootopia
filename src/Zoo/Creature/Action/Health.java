package Zoo.Creature.Action;
import IHM.UI.ZooGridElement.EnclosureIHM;
import Zoo.Creature.Creature;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static Zoo.Creature.Creature.die;

public class Health extends Thread {

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

    @Override
    public String toString() {
        return "Health{" +
                "health=" + health +
                ", sick=" + sick +
                '}';
    }

    public static void getSick(Creature creature, List<Creature> creatures, EnclosureIHM enclosureIHM) {

        // Si la créature existe
        if (creature.getName() != null){
            // Si la créature est déjà malade elle ne peut pas retomber malade
            if (creature.getHealth().getSick() != 1){
                // Génération d'un nombre entre 0.0 et 1.0
                double number = Math.random();
                if (number < 0.1) {
                    // Mettre la crature malade
                    creature.getHealth().setSick(1);
                    // Afficher que la créature est malade
                    System.out.println("\n[ALERTE] La créature " + creature.getName() + " est tombé malade\n");
                }
            }// Si la crature est déjà malade alors appeler la funciton qui lui enleve des hp
            else{
                removeHP (creature,creatures, enclosureIHM);
            }
        }

    }

    public static void removeHP (Creature creature,List<Creature> creatures, EnclosureIHM enclosureIHM){
        // Enlever un point de vie a la créature
        creature.getHealth().setHealth(creature.getHealth().getHealth()-1);
        // Si le nombre de hp de la créature est différent de 0 alors afficher le nombre d'hp restant
        if (creature.getHealth().getHealth() != 0){
            System.out.println("La créature " + creature.getName() + " a " + creature.getHealth().getHealth() + " point de vie" );
        }
        // Sinon appeler la function qui fait mourrir la créature
        else{
            die(creature,creatures,enclosureIHM);
        }

    }




    public static void disease(Creature creature){
        creature.getHealth().setSick(0);
        System.out.println("[#] La créature " + creature.getName() + " a été soigné ");
    }
    public boolean isCritical() {
        return this.health <= 0;
    }
}

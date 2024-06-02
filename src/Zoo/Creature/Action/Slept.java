package Zoo.Creature.Action;

import Zoo.Creature.Creature;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Slept {
    public int cntTurnBeforeSleep;
    public int needSleep;
    public int sleepDuration;
    public int timeSleeping;

    public Slept(int sleepDuration,int needSleep) {
        this.cntTurnBeforeSleep = 0;
        this.needSleep = needSleep;
        this.sleepDuration = sleepDuration;
        this.timeSleeping = 0;
    }

    public int getTimeSleeping() {
        return timeSleeping;
    }

    public int getSleepDuration() {
        return sleepDuration;
    }

    public int getCntTurnBeforeSleep() {
        return cntTurnBeforeSleep;
    }

    public int getNeedSleep() {
        return needSleep;
    }

    public void setNeedSleep(int needSleep) {
        this.needSleep = needSleep;
    }

    public void setCntTurnBeforeSleep(int cntTurnBeforeSleep) {
        this.cntTurnBeforeSleep = cntTurnBeforeSleep;
    }

    public void setTimeSleeping(int timeSleeping) {
        this.timeSleeping = timeSleeping;
    }

    public void setSleepDuration(int sleepDuration) {
        this.sleepDuration = sleepDuration;
    }

    @Override
    public String toString() {
        return "Slept{" +
                "cntTurnBeforeSleep=" + cntTurnBeforeSleep +
                ", needSleep=" + needSleep +
                ", sleepDuration=" + sleepDuration +
                ", timeSleeping=" + timeSleeping +
                '}';
    }

    public static void makeSlept(Creature creature) {
        // Vérifier si la créature existe
        if(creature.getName() != null){
            // Compter le nombre de jour avant que la créature est besoin de dormir


            // Si le temps de sommeil actuel de la créature est égale a la durée de son sommeille alors réveiller la créature
            if (creature.getSlept().getTimeSleeping() == creature.getSlept().getSleepDuration()){

                // Afficher que le créature se réveille
                System.out.println(creature.getName() + " se réveille");

                // Remettre les compteurs à 0
                creature.getSlept().setTimeSleeping(0);
                creature.getSlept().setCntTurnBeforeSleep(0);

            }//  Si le nombre de tour avant de faire dormir la créature est égale au nombre de tour avant que la créature est besoin de dormir
            else if(creature.getSlept().getCntTurnBeforeSleep() == creature.getSlept().getNeedSleep() ){
                // Afficher que la créature dort encore plus le temps restant
                System.out.println(creature.getName() + " dort, elle se réveillera  dans :" + (creature.getSlept().getSleepDuration() - creature.getSlept().getTimeSleeping()));
                creature.getSlept().setTimeSleeping(creature.getSlept().getTimeSleeping() + 1 );

            }// Sinon afficher quand la créature aura besoin de dormir
            else{
                //System.out.println(creature.getName() + " a besoin de dormir dans : " + (creature.getSlept().getNeedSleep() - creature.getSlept().getCntTurnBeforeSleep() )+ " tours");
                creature.getSlept().setCntTurnBeforeSleep(creature.getSlept().getCntTurnBeforeSleep() + 1);
            }
        }


    }

    public static void fallAsleep(List<Creature> creatures, Scanner scanner) {
        // Stocker les créatures pouvant être endormi
        List<Creature> noSleepCreatures = new ArrayList<>();

        // Afficher les créatures qui ne dorment pas
        System.out.println("Liste des créatures qui ne dorment pas :");
        for (Creature creature : creatures) {
            if(creature.getSlept().getCntTurnBeforeSleep() != creature.getSlept().getNeedSleep()){
                System.out.println(creature.getName());
                noSleepCreatures.add(creature);
            }
        }
        if (!noSleepCreatures.isEmpty()) {
            // Permettre à l'utilisateur de choisir quelle créature à endormir
            System.out.print("Entrez le nom de la créature à endormir : ");
            String creatureName = scanner.nextLine();


            Creature selectedCreature = null;

            // Chercher la créature sélectionnée dans le tableau des créatures disponible
            for (Creature noSleepCreature : noSleepCreatures) {
                if (noSleepCreature.getName().equals(creatureName)) {
                    selectedCreature = noSleepCreature;
                    break;
                }else{
                    System.out.println("La créature " + creatureName + " n'existe pas !");
                }
            }
            // Si la créature existe
            if (selectedCreature != null) {
              sleep(selectedCreature);
            }
        }else{
            System.out.print("Aucune créature n'est disponible ");
        }
    }
    public static void sleep(Creature creature){
        // Faire dormir la créature
        creature.getSlept().setCntTurnBeforeSleep(creature.getSlept().getNeedSleep());
        // Choisir la durée du sommeille
        creature.getSlept().setTimeSleeping(creature.getSlept().getSleepDuration() - 2);
        System.out.println("La créature " + creature.getName() + " a été endormie pour 2 tours ");
    }

}

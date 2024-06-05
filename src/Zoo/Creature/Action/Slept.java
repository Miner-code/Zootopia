package Zoo.Creature.Action;

import Zoo.Creature.Creature;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * The type Slept.
 */
public class Slept {
    /**
     * The Cnt turn before sleep.
     */
    public int cntTurnBeforeSleep;
    /**
     * The Need sleep.
     */
    public int needSleep;
    /**
     * The Sleep duration.
     */
    public int sleepDuration;
    /**
     * The Time sleeping.
     */
    public int timeSleeping;

    /**
     * Instantiates a new Slept.
     *
     * @param sleepDuration the sleep duration
     * @param needSleep     the need sleep
     */
    public Slept(int sleepDuration,int needSleep) {
        this.cntTurnBeforeSleep = 0;
        this.needSleep = needSleep;
        this.sleepDuration = sleepDuration;
        this.timeSleeping = 0;
    }

    /**
     * Gets time sleeping.
     *
     * @return the time sleeping
     */
    public int getTimeSleeping() {
        return timeSleeping;
    }

    /**
     * Gets sleep duration.
     *
     * @return the sleep duration
     */
    public int getSleepDuration() {
        return sleepDuration;
    }

    /**
     * Gets cnt turn before sleep.
     *
     * @return the cnt turn before sleep
     */
    public int getCntTurnBeforeSleep() {
        return cntTurnBeforeSleep;
    }

    /**
     * Gets need sleep.
     *
     * @return the need sleep
     */
    public int getNeedSleep() {
        return needSleep;
    }

    /**
     * Sets need sleep.
     *
     * @param needSleep the need sleep
     */
    public void setNeedSleep(int needSleep) {
        this.needSleep = needSleep;
    }

    /**
     * Sets cnt turn before sleep.
     *
     * @param cntTurnBeforeSleep the cnt turn before sleep
     */
    public void setCntTurnBeforeSleep(int cntTurnBeforeSleep) {
        this.cntTurnBeforeSleep = cntTurnBeforeSleep;
    }

    /**
     * Sets time sleeping.
     *
     * @param timeSleeping the time sleeping
     */
    public void setTimeSleeping(int timeSleeping) {
        this.timeSleeping = timeSleeping;
    }

    /**
     * Sets sleep duration.
     *
     * @param sleepDuration the sleep duration
     */
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

    /**
     * Make slept.
     *
     * @param creature the creature
     */
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


    /**
     * Sleep.
     *
     * @param creature the creature
     */
    public static void sleep(Creature creature){
        // Faire dormir la créature
        creature.getSlept().setCntTurnBeforeSleep(creature.getSlept().getNeedSleep());
        // Choisir la durée du sommeille
        creature.getSlept().setTimeSleeping(creature.getSlept().getSleepDuration() - 2);
        System.out.println("La créature " + creature.getName() + " a été endormie pour 2 tours ");
    }

}

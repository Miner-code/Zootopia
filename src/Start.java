import IHM.MainGamePanel;
import Zoo.Creature.Creature;
import Zoo.Creature.Action.Health;
import Zoo.Creature.Action.Hungry;
import Zoo.Creature.Action.Slept;
import Zoo.Creature.Species.Dragon;
import Zoo.Creature.Species.Kraken;
import Zoo.Creature.Type.*;

import Zoo.Game.Turn;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Start {
    public static void main(String[] args) {

        List<Creature> arrayCreatures = new ArrayList<>();
        //Enclosure enclosure = new Enclosure("Example Enclosure", 100, 5);

        for (int i = 0; i < 1; i++) {
            Creature licorne = new Creature("Creature" + i, true, 2, new Kraken(), 1.50, 30, new Hungry(8), new Slept(5,3),new Health(5));
            arrayCreatures.add(licorne);
        }
        Creature pumbaa = new Creature("pumbaa", true, 2, new Dragon(), 1.50, 30, new Hungry(4), new Slept(5,3),new Health(15));
        arrayCreatures.add(pumbaa);
        new MainGamePanel(arrayCreatures);
        Scanner scanner = new Scanner(System.in);

        int i = 0;

        while (i < i + 1) {
            i++;
            String line = scanner.nextLine();

            switch (line) {
                case "n" -> {
                    new Turn(arrayCreatures);
                    // Call Enclosure methods to display characteristics and maintenance
                    //enclosure.displayCharacteristics();
                    //enclosure.maintenance();
                }
                case "eat" -> {
                    Hungry.eatCreature(arrayCreatures,scanner);
                }
                case "FA" -> {
                    Slept.fallAsleep(arrayCreatures,scanner);
                }
                case "RTD" -> {
                    Health.removeTheDisease(arrayCreatures,scanner);
                }
                case "creature" -> {
                    Creature.seeCreature(arrayCreatures,scanner);
                }
                case "nc" -> {
                    Creature.newCreature(arrayCreatures,scanner);
                }
                //case "level up" -> {
                //    // Player chooses to level up the enclosure
                //    enclosure.levelUp();
                //    System.out.println("Enclosure leveled up!");
                //}
                //case "add" -> {
                //    // Player chooses to add a creature
                //    System.out.println("Enter the name of the creature to add:");
                //    String creatureName = scanner.nextLine();
                //    enclosure.addCreature(creatureName);
                //    System.out.println(creatureName + " added to the enclosure!");
                //}
                //case "remove" -> {
                //    // Player chooses to remove a creature
                //    System.out.println("Enter the name of the creature to remove:");
                //    String creatureName = scanner.nextLine();
                //    enclosure.removeCreature(creatureName);
                //    System.out.println(creatureName + " removed from the enclosure!");
                //}
            }
        }
    }
}

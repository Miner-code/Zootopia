import IHM.MainGamePanel;
import IHM.UI.Panels.SidePanel;
import IHM.UI.ZooElement.CreatureImg;
import IHM.UI.ZooElement.CreatureType;
import IHM.UI.ZooGridElement.EnclosureIHM;
import Zoo.Creature.Creature;
import Zoo.Creature.Action.Health;
import Zoo.Creature.Action.Hungry;
import Zoo.Creature.Action.Slept;
import Zoo.Creature.Species.*;
import Zoo.Creature.Type.*;

import Zoo.Enclosure.Enclosure;
import Zoo.Game.Turn;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Start {
    public static void main(String[] args) {

        List<Creature> arrayCreatures = new ArrayList<>();

        arrayCreatures.add(new Werewolf("Loukas", true, 1, 10, 40, new Hungry(5), new Slept(5, 5), new Health(10)));
        arrayCreatures.add(new Unicorn("Draco", true, 1, 15, 500, new Hungry(7), new Slept(8, 6), new Health(100)));
        arrayCreatures.add(new Mermaid("Mega", true, 1, 20, 30000, new Hungry(10), new Slept(6, 4), new Health(80)));

        List<EnclosureIHM> arrayEnclosure = new ArrayList<>();


        new MainGamePanel(arrayCreatures,arrayEnclosure);

        Scanner scanner = new Scanner(System.in);


        EnclosureIHM.addCreatureImgToEnclosure(arrayEnclosure);
        int i = 0;

        while (i < i + 1) {
            i++;
            String line = scanner.nextLine();

            switch (line) {
                //Passer un tour
                case "n" -> {
                    new Turn(arrayCreatures,arrayEnclosure);
                    // Call Enclosure methods to display characteristics and maintenance
                    //enclosure.displayCharacteristics();
                    //enclosure.maintenance();
                }
                //Donner à manger
                case "eat" -> {
                    Hungry.eatCreature(arrayCreatures,scanner);
                }
                // Sommeile
                case "FA" -> {
                    Slept.fallAsleep(arrayCreatures,scanner);
                }
                // Soigner la maladie
                case "RTD" -> {
                    Health.removeTheDisease(arrayCreatures,scanner);
                }
                // Voir la liste de creature et une creature
                case "creature" -> {
                    Creature.seeCreature(arrayCreatures,scanner);
                }
                // Créer une créature
                //case "nc" -> {
                //    Creature.newCreature(arrayCreatures,scanner,arrayEnclosure);
                //}
                // Rechercher un enclos parmis la liste d'enclos
                case "enclos" -> {
                   Enclosure.seeEnclosure(arrayEnclosure,scanner);
                }
                case "test" -> {
                    Enclosure.searchEnclosureWithFreeSpace(arrayEnclosure,scanner);
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

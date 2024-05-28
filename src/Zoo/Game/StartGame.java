package Zoo.Game;

import Zoo.Creature.*;
import Zoo.Enclosure.Enclosure;
import Zoo.Enclosure.Aviary;
import Zoo.Enclosure.Aquarium;
import Zoo.Master.FantasticZooKeeper;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StartGame {
    public static void main(String[] args) {
        List<Creature> arrayCreatures = new ArrayList<>();
        Enclosure enclosure1 = new Enclosure("Enclosure 1", 100);
        Aviary aviary = new Aviary("Aviary 1", 50, 20.0);
        Aquarium aquarium = new Aquarium("Aquarium 1", 200, 15.0, 1.5);

        Unicorn unicorn = new Unicorn("Loukas", true, 15, 1.50, true, 30);
        arrayCreatures.add(unicorn);

        Scanner scanner = new Scanner(System.in);

        FantasticZooKeeper zooKeeper = new FantasticZooKeeper("Hugo", "M", 30);

        int i = 0;

        while (true) {
            i++;
            String line = scanner.nextLine();

            switch (line) {
                case "next" -> {
                    Turn turn = new Turn(arrayCreatures, enclosure1);
                    turn.takeTurn(arrayCreatures, enclosure1);

                    enclosure1.displayCharacteristics();
                    enclosure1.maintenance();
                }
                case "level up" -> {
                    enclosure1.levelUp();
                }
                case "add" -> {
                    System.out.println("Enter the type of the creature to add (Unicorn, Werewolf, Nymph, Dragon, Phoenix, Megalodon, Kraken, Mermaid):");
                    String type = scanner.nextLine();
                    System.out.println("Enter the name of the creature to add:");
                    String creatureName = scanner.nextLine();
                    Creature newCreature = null;
                    switch (type.toLowerCase()) {
                        case "unicorn" -> newCreature = new Unicorn(creatureName, true, 10, 1.0, true, 20);
                        case "werewolf" -> newCreature = new Werewolf(creatureName, true, 10, 1.0, true, 20);
                        case "nymph" -> newCreature = new Nymph(creatureName, true, 10, 1.0, true, 20);
                        case "dragon" -> newCreature = new Dragon(creatureName, true, 10, 1.0, true, 20);
                        case "phoenix" -> newCreature = new Phoenix(creatureName, true, 10, 1.0, true, 20);
                        case "megalodon" -> newCreature = new Megalodon(creatureName, true, 10, 1.0, true, 20);
                        case "kraken" -> newCreature = new Kraken(creatureName, true, 10, 1.0, true, 20);
                        case "mermaid" -> newCreature = new Mermaid(creatureName, true, 10, 1.0, true, 20);
                        default -> System.out.println("Unknown creature type.");
                    }
                    if (newCreature != null && enclosure1.addCreature(newCreature)) {
                        arrayCreatures.add(newCreature);
                    }
                }
                case "remove" -> {
                    System.out.println("Enter the name of the creature to remove:");
                    String creatureName = scanner.nextLine();
                    enclosure1.removeCreature(creatureName);
                }
                case "clean" -> {
                    enclosure1.cleanEnclosure();
                }
                case "transfer" -> {
                    System.out.println("Enter the name of the creature to transfer:");
                    String creatureName = scanner.nextLine();
                    zooKeeper.transferCreature(creatureName, enclosure1, aviary);  // Par exemple, transférer vers aviary
                }
            }
        }
    }
}

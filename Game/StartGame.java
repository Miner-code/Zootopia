package Zoo.Game;

import Zoo.Creature.*;
import Zoo.Enclosure.Enclosure;
import Zoo.Enclosure.Aquarium;
import Zoo.Enclosure.Aviary;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StartGame {
    public static void main(String[] args) {
        List<Enclosure> enclosures = new ArrayList<>();
        List<Creature> arrayCreatures = new ArrayList<>();

        // Ajout d'un enclos initial pour les tests
        Enclosure exampleEnclosure = new Enclosure("Example Enclosure", 100);
        enclosures.add(exampleEnclosure);

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Enter command (create, add, remove, clean, transfer, next, level up, show, exit):");
            String line = scanner.nextLine();

            switch (line) {
                case "create" -> {
                    System.out.println("Enter the type of enclosure to create (enclosure, aviary, aquarium):");
                    String type = scanner.nextLine();
                    System.out.println("Enter the name of the enclosure:");
                    String name = scanner.nextLine();
                    System.out.println("Enter the area of the enclosure:");
                    double area = Double.parseDouble(scanner.nextLine());

                    Enclosure newEnclosure = null;
                    switch (type.toLowerCase()) {
                        case "enclosure" -> newEnclosure = new Enclosure(name, area);
                        case "aviary" -> {
                            System.out.println("Enter the height of the aviary:");
                            double height = Double.parseDouble(scanner.nextLine());
                            newEnclosure = new Aviary(name, area, height);
                        }
                        case "aquarium" -> {
                            System.out.println("Enter the basin depth of the aquarium:");
                            double depth = Double.parseDouble(scanner.nextLine());
                            System.out.println("Enter the water salinity of the aquarium:");
                            double salinity = Double.parseDouble(scanner.nextLine());
                            newEnclosure = new Aquarium(name, area, depth, salinity);
                        }
                        default -> System.out.println("Unknown enclosure type.");
                    }

                    if (newEnclosure != null) {
                        enclosures.add(newEnclosure);
                        System.out.println("Created new " + type + " named " + name);
                    }
                }
                case "add" -> {
                    System.out.println("Enter the name of the enclosure to add the creature to:");
                    String enclosureName = scanner.nextLine();
                    Enclosure selectedEnclosure = enclosures.stream()
                            .filter(e -> e.getName().equalsIgnoreCase(enclosureName))
                            .findFirst()
                            .orElse(null);
                    if (selectedEnclosure == null) {
                        System.out.println("Enclosure not found.");
                        break;
                    }

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

                    if (newCreature != null && selectedEnclosure.addCreature(newCreature)) {
                        arrayCreatures.add(newCreature);
                    }
                }
                case "remove" -> {
                    System.out.println("Enter the name of the enclosure to remove the creature from:");
                    String enclosureName = scanner.nextLine();
                    Enclosure selectedEnclosure = enclosures.stream()
                            .filter(e -> e.getName().equalsIgnoreCase(enclosureName))
                            .findFirst()
                            .orElse(null);
                    if (selectedEnclosure == null) {
                        System.out.println("Enclosure not found.");
                        break;
                    }

                    System.out.println("Enter the name of the creature to remove:");
                    String creatureName = scanner.nextLine();
                    selectedEnclosure.removeCreature(creatureName);
                    System.out.println(creatureName + " removed from " + selectedEnclosure.getName() + ".");
                }
                case "clean" -> {
                    System.out.println("Enter the name of the enclosure to clean:");
                    String enclosureName = scanner.nextLine();
                    Enclosure selectedEnclosure = enclosures.stream()
                            .filter(e -> e.getName().equalsIgnoreCase(enclosureName))
                            .findFirst()
                            .orElse(null);
                    if (selectedEnclosure == null) {
                        System.out.println("Enclosure not found.");
                        break;
                    }
                    selectedEnclosure.maintenance();
                }
                case "transfer" -> {
                    System.out.println("Enter the name of the source enclosure:");
                    String sourceEnclosureName = scanner.nextLine();
                    Enclosure sourceEnclosure = enclosures.stream()
                            .filter(e -> e.getName().equalsIgnoreCase(sourceEnclosureName))
                            .findFirst()
                            .orElse(null);
                    if (sourceEnclosure == null) {
                        System.out.println("Source enclosure not found.");
                        break;
                    }

                    System.out.println("Enter the name of the destination enclosure:");
                    String destinationEnclosureName = scanner.nextLine();
                    Enclosure destinationEnclosure = enclosures.stream()
                            .filter(e -> e.getName().equalsIgnoreCase(destinationEnclosureName))
                            .findFirst()
                            .orElse(null);
                    if (destinationEnclosure == null) {
                        System.out.println("Destination enclosure not found.");
                        break;
                    }

                    System.out.println("Enter the name of the creature to transfer:");
                    String creatureName = scanner.nextLine();
                    Creature creatureToTransfer = arrayCreatures.stream()
                            .filter(c -> c.getName().equals(creatureName))
                            .findFirst()
                            .orElse(null);
                    if (creatureToTransfer == null) {
                        System.out.println("Creature not found.");
                        break;
                    }
                    if (sourceEnclosure.removeCreature(creatureName) && destinationEnclosure.addCreature(creatureToTransfer)) {
                        System.out.println(creatureName + " transferred from " + sourceEnclosure.getName() + " to " + destinationEnclosure.getName() + ".");
                    } else {
                        System.out.println("Transfer failed. Check if the creature exists in the source enclosure and if the destination enclosure has enough space.");
                    }
                }
                case "next" -> {
                    for (Enclosure enclosure : enclosures) {
                        enclosure.degradeCleanliness();
                        enclosure.displayCharacteristics();
                    }
                }
                case "level up" -> {
                    System.out.println("Enter the name of the enclosure to level up:");
                    String enclosureName = scanner.nextLine();
                    Enclosure selectedEnclosure = enclosures.stream()
                            .filter(e -> e.getName().equalsIgnoreCase(enclosureName))
                            .findFirst()
                            .orElse(null);
                    if (selectedEnclosure == null) {
                        System.out.println("Enclosure not found.");
                        break;
                    }
                    selectedEnclosure.levelUp();
                }
                case "show" -> {
                    for (Enclosure enclosure : enclosures) {
                        enclosure.displayCharacteristics();
                    }
                }
                case "exit" -> {
                    System.out.println("Exiting...");
                    return;
                }
                default -> System.out.println("Unknown command.");
            }
        }
    }
}

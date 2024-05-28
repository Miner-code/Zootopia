//package Zoo.Game;
//
//import Zoo.Creature.Creature;
//import Zoo.Enclosure.Enclosure;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Scanner;
//
//public class StartGame {
//    public static void main(String[] args) {
//        List<Creature> arrayCreatures = new ArrayList<>();
//        //Enclosure enclosure = new Enclosure("Example Enclosure", 100, 5);
//
//        Creature licorne = new Creature("loukas", true, 15, "licorne", 1.50, true, 30);
//        arrayCreatures.add(licorne);
//
//        Scanner scanner = new Scanner(System.in);
//
//        int i = 0;
//
//        while (i < i + 1) {
//            i++;
//            String line = scanner.nextLine();
//
//            switch (line) {
//                case "next" -> {
//                    Turn turn = new Turn(arrayCreatures);
//                    turn.takeTurn(arrayCreatures); // Call method to take turn
//
//
//                    // Call Enclosure methods to display characteristics and maintenance
//                    //enclosure.displayCharacteristics();
//                    //enclosure.maintenance();
//                }
//                //case "level up" -> {
//                //    // Player chooses to level up the enclosure
//                //    enclosure.levelUp();
//                //    System.out.println("Enclosure leveled up!");
//                //}
//                //case "add" -> {
//                //    // Player chooses to add a creature
//                //    System.out.println("Enter the name of the creature to add:");
//                //    String creatureName = scanner.nextLine();
//                //    enclosure.addCreature(creatureName);
//                //    System.out.println(creatureName + " added to the enclosure!");
//                //}
//                //case "remove" -> {
//                //    // Player chooses to remove a creature
//                //    System.out.println("Enter the name of the creature to remove:");
//                //    String creatureName = scanner.nextLine();
//                //    enclosure.removeCreature(creatureName);
//                //    System.out.println(creatureName + " removed from the enclosure!");
//                //}
//            }//
//        }
//    }
//}
//
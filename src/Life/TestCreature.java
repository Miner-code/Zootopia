package Life;
import java.util.*;


public class TestCreature {

    public static void main(String[] args) {
        List arrayCreatures = new ArrayList();

        // Créer une créature test
        Creature licorne = new Creature("loukas", true, 15, "licorne",150, true, 30);
        arrayCreatures.add(licorne);
        Creature couilles = new Creature("couilles", true, 15, "licorne",1.50, true, 30);
        arrayCreatures.add(couilles);

         //Initialisation du scanner pour pouvoir lire dans le terminal
                Scanner scanner = new Scanner(System.in);
            // Lire la prochaine ligne du terminal

            while(licorne.getHungry().getEat() >= 0) {
                String line = scanner.nextLine();

                //Si la prochaine ligne st égale a "next" passer au tour suivant en appellant la class Turn avec comme paramètre toutes les créatures existants

                if(line.equals("next")) {
                    Turn turn = new Turn(arrayCreatures);
                } else if (line.equals("eat")) {
                    System.out.println("Chosir l'animal a nourrir : ");
                    printCreature(arrayCreatures);

                    String creatureEat = scanner.nextLine();
                    Creature creatureSelected = searchCreature(arrayCreatures,creatureEat);
                    creatureSelected.getHungry().setEat(creatureSelected.getHungry().getEat()+1);

                    System.out.println(creatureSelected.getName() +" a mangé "+ creatureSelected.getHungry().getEat());
                }


            }



    }

    public static void printCreature(List<Creature> creatures) {
        for(int i = 0; i < creatures.size(); i++) {
            System.out.println("donnée à l'indice " + i + " = " + creatures.get(i).getName());
        }
    }
    public static Creature searchCreature(List<Creature> creatures,String creatureEat) {
        for(int i = 0; i < creatures.size(); i++) {
            if(creatures.get(i).getName().equals(creatureEat)) {
                return creatures.get(i);
            }

        }
        return null;
    }

}

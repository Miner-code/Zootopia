package Life;
import java.util.*;


public class TestCreature {

    public static void main(String[] args) {
        List arrayCreatures = new ArrayList();

        // Créer une créature test
        Creature licorne = new Creature("loukas", true, 15, "licorne",1.50, true, 30);
        arrayCreatures.add(licorne);
        Creature couilles = new Creature("couilles", true, 15, "licorne",1.50, true, 30);
        arrayCreatures.add(couilles);

        // Initialisation du scanner pour pouvoir lire dans le terminal
        Scanner scanner = new Scanner(System.in);
        // Lire la prochaine ligne du terminal
        String line = scanner.nextLine();

        //Si la prochaine ligne st égale a "next" passer au tour suivant en appellant la class Turn avec comme paramètre toutes les créatures existants
        if(line.equals("next")) {
            Turn turn = new Turn(arrayCreatures);
        }

    }
}

//System.out.println("Créature 1 :" + licorne.getHungry().getEat());
//licorne.getHungry().setEat(licorne.getHungry().getEat()-1);
//System.out.println("Créature 1 :" + licorne.getHungry().getEat());
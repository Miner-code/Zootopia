package Zoo.Creature;
import IHM.UI.ZooGridElement.EnclosureIHM;
import Zoo.Creature.Action.Health;
import Zoo.Creature.Action.Hungry;
import Zoo.Creature.Action.Slept;
import Zoo.Creature.Species.*;
import Zoo.Creature.Type.Type;
import Zoo.Enclosure.Enclosure;
import Zoo.Life.Life;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Scanner;

import static Zoo.Widget.Widget.RandomNumberGenerator.generateRandomBoolean;
import static Zoo.Widget.Widget.RandomNumberGenerator.generateRandomNumber;

public abstract  class Creature extends Life  {
    public double size;
    public double weight;
    public Hungry hungry;
    public Slept slept;
    public Health health;

    public Creature(String name, boolean sex, double age, String species, double size, double weight, Hungry hungry, Slept slept, Health health) {
        super(name, sex, age, species);
        this.size = size;
        this.weight = weight;
        this.hungry = hungry;
        this.slept = slept;
        this.health = health;
    }
    public abstract Type getType();

    public Hungry getHungry() {
        return hungry;
    }

    public Slept getSlept() {
        return slept;
    }

    public Health getHealth() {
        return health;
    }


    public double getSize() {
        return size;
    }

    public double getWeight() {
        return weight;
    }



    public void setSize(double size) {
        this.size = size;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }



    @Override
    protected void scream() {

    }

    @Override
    protected void gettingOld() {

    }

    @Override
    protected void sleeping() {

    }

    @Override
    public String toString() {
        return
                "\n\tsize=" + size +
                ", \n\tweight=" + weight +
                ", \n\thungry=" + hungry +
                ", \n\tslept=" + slept +
                ", \n\thealth=" + health +
                ", \n\tspecies=" + species +
                ", \n\tage=" + age +
                ", \n\tsex=" + sex +
                ", \n\tname='" + name + '\''
                ;
    }

    public static Creature searchCreature(List<Creature> creatures, Scanner scanner, String message1, String message2){
        System.out.println(message1);
        for (Creature creature : creatures) {
            System.out.println(creature.getName());
        }

        // Permettre à l'utilisateur de choisir qu'elle créature sélectionner
        System.out.print(message2);

        String creatureName = scanner.nextLine();//scanner.nextLine()
        System.out.println(creatureName);
        // Chercher la créature dans la liste des créatures

        Creature selectedCreature = null;
        for (Creature creature : creatures) {
            System.out.println(creature.getName());
            if (creature.getName().equalsIgnoreCase(creatureName)) {
                selectedCreature = creature;
                break;
                // Arrêter la recherche dès que la créature est trouvée
            }
        }
        if (selectedCreature != null) {
            return selectedCreature;
        } else {
            System.out.println("Aucune créature trouvée avec le nom spécifié");
            return null;
        }

    }

    public static void die(Creature creature, List<Creature> creatures) {
        System.out.println("La créature " + creature.getName() + " est morte" );
        creatures.remove(creature);
    }

    public static void seeCreature(List<Creature> creatures, Scanner scanner) {
        Creature selectedCreature = searchCreature(creatures,scanner,"Liste des créature dans votre zoo:","Entrez le nom de la créature que vous voulez voir : ");
        if (selectedCreature != null){
            System.out.println(selectedCreature.getClass().getTypeName().getClass().getTypeName().getClass().getSimpleName());
            System.out.println(selectedCreature.toString());
        }

    }

    public static void newCreature(List<Creature> creatures, Scanner scanner, List<EnclosureIHM> enclosureIHMS) {
        EnclosureIHM enclosureIHMSelected = Enclosure.searchEnclosureWithFreeSpace(enclosureIHMS,scanner);
        if (enclosureIHMSelected == null) {
            System.out.println("Aucun enclos n'a été trouvé");
        }else{
            System.out.println(enclosureIHMSelected.getEnclosure().toString());

            System.out.println("Entre le nom de la créature");
            String creatureName = scanner.nextLine();
            System.out.println("Entre l'espèce (Unicorn, Werewolf, Nymph, Dragon, Phoenix, Megalodon, Kraken, Mermaid):");
            Creature newCreature = null;
            String species = scanner.nextLine();
            switch (species.toLowerCase()) {
                case "unicorn" -> newCreature = new Unicorn(creatureName, generateRandomBoolean(), 1, generateRandomNumber(1,5), generateRandomNumber(15,150),new Hungry((int) generateRandomNumber(4,10)), new Slept((int) generateRandomNumber(4,10), (int) generateRandomNumber(4,10)), new Health((int) generateRandomNumber(5,12)));
                case "werewolf" -> newCreature = new Werewolf(creatureName, generateRandomBoolean(), 1, generateRandomNumber(1,5), generateRandomNumber(15,150), new Hungry((int) generateRandomNumber(4,10)), new Slept((int) generateRandomNumber(4,10), (int) generateRandomNumber(4,10)), new Health((int) generateRandomNumber(5,12)));
                case "nymph" -> newCreature = new Nymph(creatureName, generateRandomBoolean(), 1, generateRandomNumber(1,5), generateRandomNumber(15,150), new Hungry((int) generateRandomNumber(4,10)), new Slept((int) generateRandomNumber(4,10), (int) generateRandomNumber(4,10)), new Health((int) generateRandomNumber(5,12)));
                case "dragon" -> newCreature = new Dragon(creatureName, generateRandomBoolean(), 1, generateRandomNumber(1,5), generateRandomNumber(15,150), new Hungry((int) generateRandomNumber(4,10)), new Slept((int) generateRandomNumber(4,10), (int) generateRandomNumber(4,10)), new Health((int) generateRandomNumber(5,12)));
                case "phoenix" -> newCreature = new Phoenix(creatureName, generateRandomBoolean(), 1, generateRandomNumber(1,5), generateRandomNumber(15,150), new Hungry((int) generateRandomNumber(4,10)), new Slept((int) generateRandomNumber(4,10), (int) generateRandomNumber(4,10)), new Health((int) generateRandomNumber(5,12)));
                case "megalodon" -> newCreature = new Megalodon(creatureName, generateRandomBoolean(), 1, generateRandomNumber(1,5), generateRandomNumber(15,150), new Hungry((int) generateRandomNumber(4,10)), new Slept((int) generateRandomNumber(4,10), (int) generateRandomNumber(4,10)), new Health((int) generateRandomNumber(5,12)));
                case "kraken" -> newCreature = new Kraken(creatureName, generateRandomBoolean(), 1, generateRandomNumber(1,5), generateRandomNumber(15,150), new Hungry((int) generateRandomNumber(4,10)), new Slept((int) generateRandomNumber(4,10), (int) generateRandomNumber(4,10)), new Health((int) generateRandomNumber(5,12)));
                case "mermaid" -> newCreature = new Mermaid(creatureName, generateRandomBoolean(), 1, generateRandomNumber(1,5), generateRandomNumber(15,150), new Hungry((int) generateRandomNumber(4,10)), new Slept((int) generateRandomNumber(4,10), (int) generateRandomNumber(4,10)), new Health((int) generateRandomNumber(5,12)));
                default -> System.out.println("L'espèce n'existe pas.");
            }
            if (newCreature != null){
                System.out.println(newCreature.getName() + " a bien été ajouté");
                creatures.add(newCreature);
                Enclosure.addCreatureToEnclosure(newCreature,enclosureIHMSelected);
            }else{
                System.out.println("Un problème est survenu a la création de la créature");
            }
        }

    }


}

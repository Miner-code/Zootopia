package Zoo.Creature;
import Zoo.Creature.Action.Health;
import Zoo.Creature.Action.Hungry;
import Zoo.Creature.Action.Slept;
import Zoo.Creature.Species.Dragon;
import Zoo.Creature.Species.Kraken;
import Zoo.Creature.Species.Species;
import Zoo.Creature.Type.Type;
import Zoo.Creature.Widget.Widget;
import Zoo.Life.Life;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Scanner;

import static Zoo.Creature.Widget.Widget.RandomNumberGenerator.generateRandomNumber;

public class Creature extends Life  {
    public double size;
    public double weight;
    public Hungry hungry;
    public Slept slept;
    public Health health;

    public Creature(String name, boolean sex, double age, Species species, double size, double weight, Hungry hungry, Slept slept, Health health) {
        super(name, sex, age, species);
        this.size = size;
        this.weight = weight;
        this.hungry = hungry;
        this.slept = slept;
        this.health = health;
    }

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
        return "Creature{" +
                "size=" + size +
                ", weight=" + weight +
                ", hungry=" + hungry +
                ", slept=" + slept +
                ", health=" + health +
                ", species=" + species +
                ", age=" + age +
                ", sex=" + sex +
                ", name='" + name + '\'' +
                '}';
    }

    public static Creature searchCreature(List<Creature> creatures, Scanner scanner, String message1, String message2){
        System.out.println(message1);
        for (Creature creature : creatures) {
            System.out.println(creature.getName());
        }

        // Permettre à l'utilisateur de choisir quelle créature sélectionner
        System.out.print(message2);
        String creatureName = scanner.nextLine();

        // Chercher la créature dans la liste des créatures
        Creature selectedCreature = null;
        for (Creature creature : creatures) {
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
            System.out.println(selectedCreature.toString());
        }

    }

    public static void newCreature(List<Creature> creatures, Scanner scanner) {
        System.out.println("Entre le nom de la créature");
        String creatureName = scanner.nextLine();
        System.out.println("Entre l'espèce'");
        String creatureSpecies = scanner.nextLine();
        Species species = SpeciesFactory.createSpecies(creatureSpecies);
        if (species != null) {
            Creature newCreature = new Creature(creatureName, true, 1, species, generateRandomNumber(1,3), generateRandomNumber(20,100), new Hungry((int) generateRandomNumber(4,10)), new Slept((int) generateRandomNumber(4,10), (int) generateRandomNumber(4,10)), new Health((int) generateRandomNumber(5,12)));
            creatures.add(newCreature);
            System.out.println("La créature a été ajoutée avec succès.");
        } else {
            System.out.println("Espèce inconnue.");
        }
    }

    public class SpeciesFactory {
        public static Species createSpecies(String speciesName) {
            try {
                // Assurez-vous que les classes des espèces sont dans le package correct
                Class<?> clazz = Class.forName("Zoo.Creature.Species." + speciesName);
                return (Species) clazz.getDeclaredConstructor().newInstance();
            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
                e.printStackTrace();
                return null;
            }
        }
    }

}

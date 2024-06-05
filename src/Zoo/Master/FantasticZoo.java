package Zoo.Master;

import Zoo.Enclosure.Enclosure;

/**
 * The type Fantastic zoo keeper.
 */
class FantasticZooKeeper {
    /**
     * The Name.
     */
    String name;
    /**
     * The Sex.
     */
    String sex;
    /**
     * The Age.
     */
    int age;

    /**
     * Instantiates a new Fantastic zoo keeper.
     *
     * @param name the name
     * @param sex  the sex
     * @param age  the age
     */
    public FantasticZooKeeper(String name, String sex, int age) {
        this.name = name;
        this.sex = sex;
        this.age = age;
    }

    //void inspectEnclosure(Enclosure enclosure) {
    //    enclosure.displayCharacteristics();
    //}
//
    //void cleanEnclosure(Enclosure enclosure) {
    //    enclosure.maintenance();
    //}
//
    //void feedCreaturesInEnclosure(Enclosure enclosure) {
    //    enclosure.feedCreatures();
    //}
//
    //void transferCreature(String creatureName, Enclosure sourceEnclosure, Enclosure destinationEnclosure) {
    //    if (sourceEnclosure.creaturesPresent.contains(creatureName)) {
    //        sourceEnclosure.removeCreature(creatureName);
    //        destinationEnclosure.addCreature(creatureName);
    //        System.out.println(creatureName + " has been transferred from " + sourceEnclosure.name + " to " + destinationEnclosure.name + ".");
    //    } else {
    //        System.out.println(creatureName + " is not in enclosure " + sourceEnclosure.name + ".");
    //    }
    //}
}

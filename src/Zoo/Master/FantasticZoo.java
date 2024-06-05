package Zoo.Master;

import Zoo.Enclosure.Enclosure;

class FantasticZooKeeper {
    String name;
    String sex;
    int age;

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

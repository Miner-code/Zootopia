package Zoo.Creature.Widget;


import java.util.Random;

public class Widget {

    public class RandomNumberGenerator {

        private static final Random random = new Random();

        public static double generateRandomNumber(int min, int max) {
            return min + (random.nextDouble() * (max - min));
        }
    }

}

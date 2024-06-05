package Zoo.Widget;


import java.util.Random;

public class Widget {

    public class RandomNumberGenerator {

        private static final Random random = new Random();

        public static double generateRandomNumber(int min, int max) {
            return min + (random.nextDouble() * (max - min));
        }

        public static boolean generateRandomBoolean() {
            double number = Math.random();
            if (number < 0.5) {
                return true;
            }else {
                return false;
            }
        }
    }

}

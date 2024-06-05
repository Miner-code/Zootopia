package Zoo.Widget;


import java.util.Random;

/**
 * The type Widget.
 */
public class Widget {

    /**
     * The type Random number generator.
     */
    public class RandomNumberGenerator {

        private static final Random random = new Random();

        /**
         * Generate random number double.
         *
         * @param min the min
         * @param max the max
         * @return the double
         */
        public static double generateRandomNumber(int min, int max) {
            return min + (random.nextDouble() * (max - min));
        }

        /**
         * Generate random boolean boolean.
         *
         * @return the boolean
         */
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

package com.devdyna.fertilizer.core.Utils;

import java.util.Random;

public class MathUtil {

    /**
     * 0 (inclusive) and max (exclusive)
     */
    public static int rnd(int max) {
        Random random = new Random();
        return random.nextInt(max);
    }

    /**
     * 0.0 (inclusive) and max (exclusive)
     */
    public static double rnd(double max) {
        Random random = new Random();
        return random.nextDouble(max);
    }


    /**
     * 
     * @param max exclusive
     * @param min inclusive
     * @return random value between [min,max]
     */
    public static int rnd(int max, int min) {
        if (min > max)
            return min;
         return rnd((max - min) + 1) + min;
    }

    /**
     * 
     * @param max exclusive
     * @param min inclusive
     * @return random value between [min,max]
     */
    public static double rnd(double max, double min) {
        if (min > max)
            return min;
            return rnd((max - min) + 1) + min;
    }


    /**
     * when value = 0 -> 100% false
     * 
     * @return value -> value% true
     */
    public static boolean chance(int value) {
        if (value == 0)
            return false;

        return rnd(100) <= value;
    }

    /**
     * @param size size 5
     * @return int [1|2|3|4]
     */
    public static int rndSelector(int size) {
        return rnd(0, size - 1);
    }

    
    
  

}

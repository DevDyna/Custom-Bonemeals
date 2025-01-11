package com.devdyna.fertilizer.core.Utils;

import java.util.Random;

public class MathUtil {

    /**
     * 0 (inclusive) and 1 (exclusive)
     */
    public static int rndInt() {
        Random random = new Random();
        return random.nextInt();
    }

    /**
     * 0.0 (inclusive) and 1.0 (exclusive)
     */
    public static double rndDouble() {
        Random random = new Random();
        return random.nextDouble();
    }

    /**
     * 
     * @param max exclusive
     * @return random value between [0,max]
     */
    public static int rnd(int max) {
        if (max <= 0)
            return 0;
        return  0 + (rndInt() * (max - 0));
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
         return  min + (rndInt() * (max - min));
    }

    /**
     * 
     * @param max exclusive
     * @return random value between [0,max]
     */
    public static double rnd(double max) {
        if (max <= 0)
            return 0;
        return  0 + (rndDouble() * (max - 0));
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
        return   min + (rndDouble() * (max - min));
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

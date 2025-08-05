package com.sinuke.easy;

public class FruitsIntoBasketsII {

    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int count = 0;
        for (int fruit : fruits) {
            boolean found = false;
            for (int i = 0; i < baskets.length; i++) {
                if (baskets[i] >= fruit) {
                    found = true;
                    baskets[i] = -1;
                    break;
                }
            }
            count += found ? 0 : 1;
        }
        return count;
    }

}

package com.sinuke.easy;

public class WaterBottles {

    public int numWaterBottles(int numBottles, int numExchange) {
        int count = numBottles;

        while (numBottles >= numExchange) {
            int tmp = numBottles % numExchange;
            numBottles /= numExchange;
            count += numBottles;
            numBottles += tmp;
        }

        return count;
    }

}

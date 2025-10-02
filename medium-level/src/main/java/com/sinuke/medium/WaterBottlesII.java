package com.sinuke.medium;

public class WaterBottlesII {

    public int maxBottlesDrunk(int numBottles, int numExchange) {
        int empty = numBottles, drunk = numBottles;
        numBottles = 0;
        while (numBottles + empty >= numExchange) {
            if (empty < numExchange) {
                // drink
                drunk += numBottles;
                empty += numBottles;
                numBottles = 0;
            } else {
                // exchange
                empty -= numExchange;
                numBottles++;
                numExchange++;
            }
        }
        return drunk + numBottles;
    }

}

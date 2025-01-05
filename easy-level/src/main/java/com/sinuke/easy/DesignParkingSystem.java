package com.sinuke.easy;

public class DesignParkingSystem {

    public static class ParkingSystem {

        private final int[] capacity = new int[3];
        private final int[] busy = new int[3];

        public ParkingSystem(int big, int medium, int small) {
            capacity[0] = big;
            capacity[1] = medium;
            capacity[2] = small;
        }

        public boolean addCar(int carType) {
            if (busy[carType - 1] >= capacity[carType - 1]) return false;

            busy[carType - 1]++;
            return true;
        }

    }

}

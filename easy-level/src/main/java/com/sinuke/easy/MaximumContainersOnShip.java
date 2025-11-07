package com.sinuke.easy;

public class MaximumContainersOnShip {

    public int maxContainers(int n, int w, int maxWeight) {
        return Math.min(maxWeight / w, n * n);
    }

}

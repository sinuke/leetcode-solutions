package com.sinuke.easy;

public class MinimumCapacityBox {

    public int minimumIndex(int[] capacity, int itemSize) {
        int min = -1;
        for (int i = 0; i < capacity.length; i++) {
            if (capacity[i] >= itemSize) min = min == -1 || capacity[i] < capacity[min] ? i : min;
        }
        return min;
    }

}

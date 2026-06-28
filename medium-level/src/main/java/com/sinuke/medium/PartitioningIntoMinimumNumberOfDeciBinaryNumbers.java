package com.sinuke.medium;

public class PartitioningIntoMinimumNumberOfDeciBinaryNumbers {

    public int minPartitions(String n) {
        int max = 0;
        for (char c : n.toCharArray()) {
            max = Math.max(max, c - '0');
        }
        return max;
    }

}

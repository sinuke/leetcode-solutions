package com.sinuke.easy;

public class PartitionArrayAccordingToGivenPivot {

    public int[] pivotArray(int[] nums, int pivot) {
        int countLess = 0, countEqual = 0, countGreater = 0;
        for (int num : nums) {
            if (num == pivot) countEqual++;
            else if (num < pivot) countLess++;
            else countGreater++;
        }

        int indexLess = 0, indexEqual = 0, indexGreater = 0;
        int[] result = new int[nums.length];
        for (int num : nums) {
            if (num == pivot) result[countLess + indexEqual++] = num;
            else if (num < pivot) result[indexLess++] = num;
            else result[countLess + countEqual + indexGreater++] = num;
        }
        return result;
    }

}

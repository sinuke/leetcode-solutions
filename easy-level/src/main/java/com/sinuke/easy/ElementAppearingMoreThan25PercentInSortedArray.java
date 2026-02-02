package com.sinuke.easy;

public class ElementAppearingMoreThan25PercentInSortedArray {

    public int findSpecialInteger(int[] arr) {
        int n = arr.length / 4;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == arr[i + n]) return arr[i];
        }
        return arr[arr.length - 1];
    }

}

package com.sinuke.easy;

public class ReplaceElementsWithGreatestElementOnRightSide {

    public int[] replaceElements(int[] arr) {
        int max = -1;

        for (int i = arr.length - 1; i >= 0; i--) {
            int tmp = arr[i];
            arr[i] = max;
            if (tmp > max) max = tmp;
        }

        return arr;
    }

}

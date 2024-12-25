package com.sinuke.easy;

import java.util.HashSet;
import java.util.Set;

public class CheckIfNAndItsDoubleExist {

    public boolean checkIfExist(int[] arr) {
        Set<Integer> set = new HashSet<>();

        for (int value : arr) {
            if (set.contains(value * 2) || (value % 2 == 0 && set.contains(value / 2))) return true;
            else set.add(value);
        }

        return false;
    }

}

package com.sinuke.easy;

import java.util.Arrays;
import java.util.Comparator;

public class SortIntegersByTheNumberOf1Bits {

    public int[] sortByBits(int[] arr) {
        return Arrays.stream(arr)
                .boxed()
                .sorted(Comparator.comparingInt(Integer::bitCount).thenComparing(i -> i))
                .mapToInt(i -> i)
                .toArray();
    }

}

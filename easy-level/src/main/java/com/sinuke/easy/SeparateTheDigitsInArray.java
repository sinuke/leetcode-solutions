package com.sinuke.easy;

import java.util.LinkedList;
import java.util.List;

public class SeparateTheDigitsInArray {

    public int[] separateDigits(int[] nums) {
        List<Integer> lst = new LinkedList<>();
        for (int num : nums) {
            String numStr = String.valueOf(num);
            for (char c : numStr.toCharArray()) {
                lst.add(c - '0');
            }
        }
        return lst.stream().mapToInt(i -> i).toArray();
    }

}

package com.sinuke.easy;

import java.util.ArrayList;
import java.util.List;

public class SelfDividingNumbers {

    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> result = new ArrayList<>(right - left + 1);
        for (int i = left; i <= right; i++) {
            if (isSelfDividingNumber(i)) result.add(i);
        }
        return result;
    }

    private boolean isSelfDividingNumber(int num) {
        int original = num;

        while (num > 0) {
            int digit = num % 10;
            if (digit == 0 || original % digit != 0) return false;
            num /= 10;
        }

        return true;
    }

}

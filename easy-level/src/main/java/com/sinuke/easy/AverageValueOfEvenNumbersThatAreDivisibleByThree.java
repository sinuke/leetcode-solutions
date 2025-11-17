package com.sinuke.easy;

public class AverageValueOfEvenNumbersThatAreDivisibleByThree {

    public int averageValue(int[] nums) {
        int sum = 0, count = 0;
        for (int num : nums) {
            if (num % 2 == 0 && num % 3 == 0) {
                sum += num;
                count++;
            }
        }
        return count == 0 ? 0 : sum / count;
    }

}

package com.sinuke.easy;

public class NumberOfStepsToReduceNumberToZero {

    public int numberOfSteps(int num) {
        int count = 0;

        while (num > 0) {
            num = (num % 2 == 0) ? num / 2 : num - 1;
            count++;
        }

        return count;
    }

}

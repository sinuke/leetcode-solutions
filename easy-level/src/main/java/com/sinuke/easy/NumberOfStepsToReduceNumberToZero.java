package com.sinuke.easy;

public class NumberOfStepsToReduceNumberToZero {

    public int numberOfSteps(int num) {
        int count = 0;

        while (num > 0) {
            if (num % 2 == 0) num /= 2;
            else num--;

            count++;
        }

        return count;
    }

}

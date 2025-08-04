package com.sinuke.easy;

public class PerfectNumber {

    public boolean checkPerfectNumber(int num) {
        if (num == 1) return false;

        int i = 1, sum = 0;
        long smallest = Math.round(Math.sqrt(num));
        while (i <= num / smallest) {
            if (num % i == 0) {
                sum += i;
                if (i > 1 && i < smallest) smallest = i;
            }
            i++;
        }
        return sum == num;
    }

}

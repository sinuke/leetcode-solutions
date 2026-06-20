package com.sinuke.easy;

public class MaximumNumberOfBallsInBox {

    public int countBalls(int lowLimit, int highLimit) {
        int max = 0, prev = 0;
        int[] freq = new int[46];
        for (int i = lowLimit; i <= highLimit; i++) {
            int s = i == lowLimit || i % 10 == 0 ? sum(i) : prev + 1;
            prev = s;
            freq[s]++;
            if (freq[s] > freq[max]) max = s;
        }
        return freq[max];
    }

    private int sum(int n) {
        int sum = 0;
        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }

}

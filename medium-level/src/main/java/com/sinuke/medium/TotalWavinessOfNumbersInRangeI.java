package com.sinuke.medium;

public class TotalWavinessOfNumbersInRangeI {

    public int totalWaviness(int num1, int num2) {
        int sum = 0;
        for (int n = num1; n <= num2; n++) {
            sum += getWaviness(n);
        }
        return sum;
    }

    private int getWaviness(int n) {
        int prev = -1, waviness = 0;
        while (n > 0) {
            int d = n % 10;
            if (prev != -1 && n / 10 > 0) {
                int next = (n / 10) % 10;
                if ((d > prev && d > next) || (d < prev && d < next)) waviness++;
            }
            prev = d;
            n /= 10;
        }
        return waviness;
    }

}

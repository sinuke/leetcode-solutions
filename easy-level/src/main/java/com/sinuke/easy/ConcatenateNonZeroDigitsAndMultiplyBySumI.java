package com.sinuke.easy;

public class ConcatenateNonZeroDigitsAndMultiplyBySumI {

    public long sumAndMultiply(int n) {
        var sb = new StringBuilder();
        long sum = 0;
        while (n > 0) {
            int d = n % 10;
            if (d > 0) {
                sb.append(d);
                sum += d;
            }
            n /= 10;
        }

        return (sb.isEmpty() ? 0 : Long.parseLong(sb.reverse().toString())) * sum;
    }

}

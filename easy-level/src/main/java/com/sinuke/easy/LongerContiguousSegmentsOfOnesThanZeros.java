package com.sinuke.easy;

public class LongerContiguousSegmentsOfOnesThanZeros {

    public boolean checkZeroOnes(String s) {
        int maxOnes = 0, maxZeros = 0;
        int countOnes = 0, countZeros = 0;

        for (char c : s.toCharArray()) {
            if (c == '0') {
                countZeros++;
                countOnes = 0;
            } else {
                countOnes++;
                countZeros = 0;
            }
            maxOnes = Math.max(countOnes, maxOnes);
            maxZeros = Math.max(countZeros, maxZeros);
        }

        return maxOnes > maxZeros;
    }

}

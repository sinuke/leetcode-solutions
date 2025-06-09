package com.sinuke.easy;

public class NumberOfEvenAndOddBits {

    public int[] evenOddBit(int n) {
        String bin = Integer.toBinaryString(n);
        int even = 0, odd = 0;
        for (int i = bin.length() - 1; i >= 0; i--) {
            if (bin.charAt(i) == '1') {
                if ((bin.length() - 1 - i) % 2 == 0) even++;
                else odd++;
            }
        }
        return new int[] {even, odd};
    }

}

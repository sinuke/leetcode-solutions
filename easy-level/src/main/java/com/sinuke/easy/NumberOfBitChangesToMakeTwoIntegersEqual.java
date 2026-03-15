package com.sinuke.easy;

public class NumberOfBitChangesToMakeTwoIntegersEqual {

    public int minChanges(int n, int k) {
        String nBin = Integer.toBinaryString(n);
        String kBin = Integer.toBinaryString(k);

        if (nBin.length() < kBin.length()) return -1;

        int count = 0;
        int i = nBin.length() - 1, j = kBin.length() - 1;

        while (i >= 0) {
            if (j >= 0 && nBin.charAt(i) == kBin.charAt(j)) {
                i--;
                j--;
            } else if (j >= 0 && nBin.charAt(i) == '0' && kBin.charAt(j) == '1') return -1;
            else if (j >= 0 && nBin.charAt(i) == '1' && kBin.charAt(j) == '0') {
                i--;
                j--;
                count++;
            } else if (j < 0 && nBin.charAt(i) == '1') {
                i--;
                count++;
            } else if (j < 0 && nBin.charAt(i) == '0') i--;
        }

        return count;
    }

}

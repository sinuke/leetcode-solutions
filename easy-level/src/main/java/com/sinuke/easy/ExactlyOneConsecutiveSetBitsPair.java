package com.sinuke.easy;

public class ExactlyOneConsecutiveSetBitsPair {

    public boolean consecutiveSetBits(int n) {
        String bin = Integer.toBinaryString(n);
        char prev = bin.charAt(0);
        int cnt = 1, total = 0;
        for (int i = 1; i < bin.length(); i++) {
            if (bin.charAt(i) == prev && bin.charAt(i) == '1') cnt++;
            else if (bin.charAt(i) != prev && bin.charAt(i) == '0') {
                if (cnt > 1) total += cnt % 2 == 0 ? cnt / 2 : cnt / 2 + 1;
                cnt = 1;
                if (total > 1) break;
            }
            prev = bin.charAt(i);
        }
        if (cnt > 1) total += cnt % 2 == 0 ? cnt / 2 : cnt / 2 + 1;
        return total == 1;
    }

}

package com.sinuke.easy;

public class JewelsAndStones {

    public int numJewelsInStones(String jewels, String stones) {
        char[] jewelChars = new char[255];

        for (char c : jewels.toCharArray()) {
            jewelChars[c]++;
        }

        int result = 0;
        for (char c : stones.toCharArray()) {
            if (jewelChars[c] > 0) result++;
        }
        return result;
    }

}

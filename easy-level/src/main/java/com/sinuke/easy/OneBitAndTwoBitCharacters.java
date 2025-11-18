package com.sinuke.easy;

public class OneBitAndTwoBitCharacters {

    public boolean isOneBitCharacter(int[] bits) {
        boolean isOne = bits[0] == 0;
        int i = isOne ? 1 : 2;

        while (i < bits.length) {
            if (bits[i] == 1) {
                isOne = false;
                i++;
            } else isOne = true;
            i++;
        }

        return isOne;
    }

}

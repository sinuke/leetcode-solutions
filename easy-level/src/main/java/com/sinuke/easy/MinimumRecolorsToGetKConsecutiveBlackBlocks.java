package com.sinuke.easy;

public class MinimumRecolorsToGetKConsecutiveBlackBlocks {

    public int minimumRecolors(String blocks, int k) {
        char[] chars = blocks.toCharArray();
        int result = Integer.MAX_VALUE;

        for (int i = 0; i <= chars.length - k; i++) {
            int count = recolor(chars, i, i + k);
            if (result > count) result = count;
        }

        return result;
    }

    private int recolor(char[] chars, int start, int end) {
        int count = 0;
        for (int i = start; i < end; i++) {
            if (chars[i] == 'W') count++;
        }

        return count;
    }

}

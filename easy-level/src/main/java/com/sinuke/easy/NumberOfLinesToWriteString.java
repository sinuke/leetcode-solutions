package com.sinuke.easy;

public class NumberOfLinesToWriteString {

    public int[] numberOfLines(int[] widths, String s) {
        int[] result = new int[2];
        int line = 0;
        for (char c : s.toCharArray()) {
            int w = widths[c - 'a'];
            if (line + w == 100) {
                result[0]++;
                line = 0;
            } else if (line + w > 100) {
                result[0]++;
                line = w;
            } else line += w;
        }
        if (line == 0) result[1] = 100;
        else {
            result[0]++;
            result[1] = line;
        }

        return result;
    }

}

package com.sinuke.easy;

public class ShortestDistanceToCharacter {

    public int[] shortestToChar(String s, char c) {
        int[] result = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == c) {
                result[i] = 0;
                int j = i, k = i;
                while (j >= 0 || k <= s.length() - 1) {
                    if (j >= 0 && ((result[j] == 0 && s.charAt(j) != c) || i - j < result[j])) result[j] = i - j;
                    if (k <= s.length() - 1 && ((result[k] == 0 && s.charAt(k) != c) || k - i < result[k])) result[k] = k - i;
                    j--; k++;
                }
            }
        }
        return result;
    }

}

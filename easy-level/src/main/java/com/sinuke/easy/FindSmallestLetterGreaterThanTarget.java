package com.sinuke.easy;

public class FindSmallestLetterGreaterThanTarget {

    // 0 ms - 100%
    public char nextGreatestLetter(char[] letters, char target) {
        int i = 0;
        while (i < letters.length && letters[i] <= target) i++;
        return i < letters.length ? letters[i] : letters[0];
    }

    // 0 ms - 100%
    public char nextGreatestLetter2(char[] letters, char target) {
        int l = 0, r = letters.length - 1;
        while (r >= l) {
            int m = (l + r) / 2;
            if (letters[m] <= target) l = m + 1;
            else r = m - 1;
        }
        return l < letters.length ? letters[l] : letters[0];
    }

}

package com.sinuke.easy;

import java.util.Arrays;

public class TruncateSentence {

    // 2 ms
    public String truncateSentence(String s, int k) {
        var sentences = s.split(" ");
        return String.join(" ", Arrays.copyOf(sentences, k));
    }

    // 0 ms
    public String truncateSentence2(String s, int k) {
        int count = 0, i = 0;

        while (count < k && i < s.length()) {
            if (s.charAt(i) == ' ') count++;
            i++;
        }

        return s.substring(0, i == s.length() ? i : i - 1);
    }

}

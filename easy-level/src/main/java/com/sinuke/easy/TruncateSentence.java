package com.sinuke.easy;

import java.util.Arrays;

public class TruncateSentence {

    public String truncateSentence(String s, int k) {
        var sentences = s.split(" ");
        return String.join(" ", Arrays.copyOf(sentences, k));
    }

}

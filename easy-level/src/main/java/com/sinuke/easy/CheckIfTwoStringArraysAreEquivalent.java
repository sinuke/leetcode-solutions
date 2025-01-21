package com.sinuke.easy;

public class CheckIfTwoStringArraysAreEquivalent {

    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        var w1 = String.join("", word1);
        var w2 = String.join("", word2);

        return w1.equals(w2);
    }

}

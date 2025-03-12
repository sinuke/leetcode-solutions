package com.sinuke.easy;

import java.util.List;

public class CheckIfStringIsAcronymOfWords {

    public boolean isAcronym(List<String> words, String s) {
        var sb = new StringBuilder();
        for (var w : words) sb.append(w.charAt(0));
        return sb.toString().equals(s);
    }

}

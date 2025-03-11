package com.sinuke.easy;

import java.util.List;

public class CheckIfStringIsAcronymOfWords {

    public boolean isAcronym(List<String> words, String s) {
        var sb = new StringBuilder();
        words.forEach(w -> sb.append(w.charAt(0)));
        return sb.toString().equals(s);
    }

}

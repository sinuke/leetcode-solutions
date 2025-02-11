package com.sinuke.medium;

public class RemoveAllOccurrencesOfSubstring {

    public String removeOccurrences(String s, String part) {
        int index = s.indexOf(part);

        while (index != -1) {
            s = s.replaceFirst(part, "");
            index = s.indexOf(part, index - part.length());
        }

        return s;
    }

}

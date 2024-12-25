package com.sinuke.medium;

public class AddingSpacesToString {

    public String addSpaces(String s, int[] spaces) {
        int i = 0;
        int lastI = 0;
        int index = 0;

        var result = new StringBuilder(s.length() + spaces.length);
        while (i < s.length()) {
            if (index != spaces.length && i == spaces[index]) {
                result.append(s, lastI, i).append(" ");
                lastI = i;
                index++;
            } else {
                i++;
            }
        }

        if (lastI != i) result.append(s, lastI, i);

        return result.toString();
    }

}

package com.sinuke.easy;

public class SortingTheSentence {

    public String sortSentence(String s) {
        String[] words = s.split(" ");
        String[] sorted = new String[words.length];

        for (String word : words) {
            int index = (word.charAt(word.length() - 1) - '0') - 1;
            sorted[index] = word.substring(0, word.length() - 1);
        }

        return String.join(" ", sorted);
    }

}

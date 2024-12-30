package com.sinuke.easy;

public class ReverseWordsInStringIII {

    public String reverseWords(String s) {
        var words = s.split(" ");

        for (int i = 0; i < words.length; i++) {
            words[i] = new StringBuilder(words[i]).reverse().toString();
        }

        return String.join(" ", words);
    }

}

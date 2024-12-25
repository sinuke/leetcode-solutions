package com.sinuke.easy;

public class CheckIfWordOccursAsPrefixOfAnyWordInSentence {

    public int isPrefixOfWord(String sentence, String searchWord) {
        var words = sentence.split(" ");

        for (int i = 0; i < words.length; i++) {
            if (words[i].startsWith(searchWord)) return i + 1;
        }

        return -1;
    }

}

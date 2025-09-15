package com.sinuke.easy;

public class MaximumNumberOfWordsYouCanType {

    public int canBeTypedWords(String text, String brokenLetters) {
        char[] set = new char[26];
        for (char c : brokenLetters.toCharArray()) {
            set[c - 'a'] = 1;
        }

        int count = 0;
        boolean broken = false;
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (c == ' ') {
                count += broken ? 0 : 1;
                broken = false;
            } else if (set[c - 'a'] == 1) broken = true;
        }
        count += broken ? 0 : 1;
        return count;
    }

}

package com.sinuke.easy;

public class GoatLatin {

    public String toGoatLatin(String sentence) {
        var a = new StringBuilder("a");
        var result = new StringBuilder();
        for (var word : sentence.split(" ")) {
            char c = word.charAt(0);
            if (isVowel(c)) result.append(word).append("ma");
            else result.append(word, 1, word.length()).append(c).append("ma");
            result.append(a).append(" ");
            a.append("a");
        }
        result.setLength(result.length() - 1);
        return result.toString();
    }

    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
    }

}

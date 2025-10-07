package com.sinuke.medium;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ReplaceWords {

    public String replaceWords(List<String> dictionary, String sentence) {
        Set<String> dict = new HashSet<>(dictionary);
        String[] words = sentence.split(" ");
        var result = new StringBuilder();

        for (int i = 0; i < words.length; i++) {
            var word = words[i];
            var sb = new StringBuilder();
            for (int j = 0; j < word.length(); j++) {
                sb.append(word.charAt(j));
                var s = sb.toString();
                if (dict.contains(s)) {
                    word = s;
                    break;
                }
            }
            result.append(word).append(' ');
        }

        return result.deleteCharAt(result.length() - 1).toString();
    }

    public String replaceWords2(List<String> dictionary, String sentence) {
        Set<String> dict = new HashSet<>(dictionary);
        var result = new StringBuilder();
        int start = 0;

        for (int end = 0; end < sentence.length(); end++) {
            if (sentence.charAt(end) == ' ' || end == sentence.length() - 1) {
                var word = sentence.substring(start, end);
                var sb = new StringBuilder();
                for (int j = 0; j < word.length(); j++) {
                    sb.append(word.charAt(j));
                    var s = sb.toString();
                    if (dict.contains(s)) {
                        word = s;
                        break;
                    }
                }
                result.append(word).append(' ');
                end++;
                start = end;
            }
        }

        return result.deleteCharAt(result.length() - 1).toString();
    }

    public String replaceWords3(List<String> dictionary, String sentence) {
        Set<String> dict = new HashSet<>(dictionary);
        var result = new StringBuilder();
        var sb = new StringBuilder();
        boolean changed = false;

        for (int end = 0; end < sentence.length(); end++) {
            if (sentence.charAt(end) == ' ' || end == sentence.length() - 1) {
                if (!changed) result.append(sb).append(' ');
                changed = false;
                sb.delete(0, sb.length());
                //sb = new StringBuilder();
            } else if (!changed) {
                var w = sb.append(sentence.charAt(end)).toString();
                if (dict.contains(w)) {
                    changed = true;
                    result.append(w).append(' ');
                }
            }
        }

        return result.deleteCharAt(result.length() - 1).toString();
    }

}

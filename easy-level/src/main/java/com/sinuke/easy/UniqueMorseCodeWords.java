package com.sinuke.easy;

import java.util.HashSet;
import java.util.Set;

public class UniqueMorseCodeWords {

    public int uniqueMorseRepresentations(String[] words) {
        var codes = new String[] {
                ".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",
                ".-.","...","-","..-","...-",".--","-..-","-.--","--.."
        };

        Set<String> set = new HashSet<>();
        int count = words.length;

        for (var word : words) {
            var sb = new StringBuilder();
            for (char c : word.toCharArray()) sb.append(codes[c - 'a']);
            if (set.contains(sb.toString())) count--;
            else set.add(sb.toString());
        }

        return count;
    }

}

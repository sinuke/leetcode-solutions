package com.sinuke.easy;

import java.util.HashMap;
import java.util.Map;

public class UncommonWordsFromTwoSentences {

    public String[] uncommonFromSentences(String s1, String s2) {
        Map<String, Integer> counts = new HashMap<>();
        var words1 = s1.split(" ");
        var words2 = s2.split(" ");
        int i = 0, j = 0;

        int count = 0;
        while (i < words1.length || j < words2.length) {
            if (i < words1.length) {
                if (counts.containsKey(words1[i]) && counts.get(words1[i]) == 1) count--;
                else if (!counts.containsKey(words1[i])) count++;
                counts.put(words1[i], counts.getOrDefault(words1[i], 0) + 1);
                i++;
            }

            if (j < words2.length) {
                if (counts.containsKey(words2[j]) && counts.get(words2[j]) == 1) count--;
                else if (!counts.containsKey(words2[j])) count++;
                counts.put(words2[j], counts.getOrDefault(words2[j], 0) + 1);
                j++;
            }
        }

        var result = new String[count];
        i = 0;
        for (var entry : counts.entrySet()) {
            if (entry.getValue() == 1) result[i++] = entry.getKey();
        }

        return result;
    }

}

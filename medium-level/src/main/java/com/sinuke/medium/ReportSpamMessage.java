package com.sinuke.medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ReportSpamMessage {

    public boolean reportSpam(String[] message, String[] bannedWords) {
        Set<String> set = new HashSet<>(Arrays.stream(bannedWords).toList());
        int counter = 0;
        for (String word : message) {
            if (set.contains(word)) {
                counter++;
                if (counter >= 2) return true;
            }
        }
        return false;
    }

}

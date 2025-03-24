package com.sinuke.easy;

public class NumberOfChangingKeys {

    public int countKeyChanges(String s) {
        int count = 0;

        char prev = Character.toLowerCase(s.charAt(0));
        for (var i = 1; i < s.length(); i++) {
            char curr = Character.toLowerCase(s.charAt(i));
            if (prev != curr) count++;
            prev = curr;
        }

        return count;
    }

}

package com.sinuke.easy;

public class RearrangeStringToAvoidCharacterPair {

    public String rearrangeString(String s, char x, char y) {
        var sb1 = new StringBuilder();
        var sb2 = new StringBuilder();
        var sb3 = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (c == y) sb1.append(c);
            else if (c == x) sb3.append(c);
            else sb2.append(c);
        }

        return sb1.append(sb2).append(sb3).toString();
    }

}

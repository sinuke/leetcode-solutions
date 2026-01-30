package com.sinuke.easy;

public class CheckIfStringIsPrefixOfArray {

    public boolean isPrefixString(String s, String[] words) {
        var sb = new StringBuilder();
        for (String word : words) {
            sb.append(word);
            if (sb.length() == s.length() && sb.toString().equals(s)) return true;
            else if (sb.length() > s.length()) return false;
        }
        return false;
    }

}

package com.sinuke.easy;

public class ClearDigits {

    public String clearDigits(String s) {
        var sb = new StringBuilder();

        for (var c : s.toCharArray()) {
            if (Character.isDigit(c)) sb.deleteCharAt(sb.length() - 1);
            else sb.append(c);
        }

        return sb.toString();
    }

}

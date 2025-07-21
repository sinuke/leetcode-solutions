package com.sinuke.easy;

public class DeleteCharactersToMakeFancyString {

    public String makeFancyString(String s) {
        var sb = new StringBuilder();
        sb.append(s.charAt(0));

        int cnt = 1;
        for (int i = 1; i < s.length(); i++) {
            cnt = s.charAt(i) == s.charAt(i - 1) ? cnt + 1 : 1;
            if (cnt < 3) sb.append(s.charAt(i));
        }

        return sb.toString();
    }

}

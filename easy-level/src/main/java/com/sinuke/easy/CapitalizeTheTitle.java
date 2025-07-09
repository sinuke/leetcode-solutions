package com.sinuke.easy;

public class CapitalizeTheTitle {

    public String capitalizeTitle(String title) {
        var sb = new StringBuilder(title.length());
        int j = 0;
        for (int i = 0; i < title.length(); i++) {
            char c = title.charAt(i);
            sb.append(Character.toLowerCase(c));

            if (c == ' ') {
                if (i - j > 2) sb.setCharAt(j, Character.toUpperCase(sb.charAt(j)));
                j = i + 1;
            }
        }

        if (title.length() - j > 2) sb.setCharAt(j, Character.toUpperCase(sb.charAt(j)));

        return sb.toString();
    }

}

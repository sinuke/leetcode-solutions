package com.sinuke.easy;

public class LicenseKeyFormatting {

    public String licenseKeyFormatting(String s, int k) {
        var sb = new StringBuilder();
        int gcount = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '-') continue;
            sb.append(Character.toUpperCase(s.charAt(i)));
            gcount++;
            if (gcount == k) {
                gcount = 0;
                sb.append('-');
            }
        }
        if (!sb.isEmpty() && sb.charAt(sb.length() - 1) == '-') sb.deleteCharAt(sb.length() - 1);
        return sb.reverse().toString();
    }

}

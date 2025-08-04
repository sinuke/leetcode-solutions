package com.sinuke.easy;

import java.util.Arrays;

public class LicenseKeyFormatting {

    // 10 ms
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

    // 7 ms
    public String licenseKeyFormatting2(String s, int k) {
        char[] dp = new char[s.length() + s.length() / k + 1];
        int gcount = 0, j = dp.length - 1;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '-') continue;
            dp[j--] = Character.toUpperCase(s.charAt(i));
            gcount++;
            if (gcount == k && j > 0) {
                gcount = 0;
                dp[j--] = '-';
            }
        }
        return new String(Arrays.copyOfRange(dp, j + 1 < dp.length - 1 && dp[j + 1] == '-' ? j + 2 : j + 1, dp.length));
    }

}

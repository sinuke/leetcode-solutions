package com.sinuke;

public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
        var minStr = strs[0];
        for (int i = 1; i < strs.length; i++) {
            if (strs[i].length() < minStr.length()) {
                minStr = strs[i];
            }
        }

        var result = "";
        for (int i = minStr.length(); i >= 0; i--) {
            var ok = true;
            result = minStr.substring(0, i);

            for (String str : strs) {
                if (!str.startsWith(result)) {
                    ok = false;
                    break;
                }
            }

            if (ok) {
                break;
            }
        }

        return result;
    }

}

package com.sinuke.easy;

public class DivideStringIntoGroupsOfSizeK {

    public String[] divideString(String s, int k, char fill) {
        var result = new String[s.length() % k == 0 ? s.length() / k : s.length() / k + 1];
        int i = 0, index = 0;
        while (i < s.length()) {
            result[index++] = s.substring(i, Math.min(i + k, s.length()));
            i += k;
        }

        if (result[index - 1].length() < k) {
            var sb = new StringBuilder(result[index - 1]);
            while (sb.length() < k) sb.append(fill);
            result[index - 1] = sb.toString();
        }

        return result;
    }

}

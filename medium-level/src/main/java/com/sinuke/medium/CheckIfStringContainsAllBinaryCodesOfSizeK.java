package com.sinuke.medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CheckIfStringContainsAllBinaryCodesOfSizeK {

    // 223 ms
    public boolean hasAllCodes(String s, int k) {
        Set<String> set = new HashSet<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length - k + 1; i++) {
            set.add(new String(Arrays.copyOfRange(chars, i, i + k)));
        }
        return set.size() == (int) Math.pow(2, k);
    }

    // 225 ms
    public boolean hasAllCodes3(String s, int k) {
        Set<String> set = new HashSet<>();
        var sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            sb.append(s.charAt(i));
            if (sb.length() == k + 1) sb.deleteCharAt(0);
            if (sb.length() == k) set.add(sb.toString());
        }
        return set.size() == (int) Math.pow(2, k);
    }

    // 175 ms
    public boolean hasAllCodes2(String s, int k) {
        Set<String> set = new HashSet<>();
        for (int i = 0; i < s.length() - k + 1; i++) {
            set.add(s.substring(i, i + k));
        }
        return set.size() == (int) Math.pow(2, k);
    }

}

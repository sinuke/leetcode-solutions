package com.sinuke.easy;

import java.util.Set;

public class StrongPasswordCheckerII {

    private static final Set<Character> special = Set.of(
            '!', '@', '#', '$', '%', '^', '&', '*', '(', ')', '-', '+'
    );

    public boolean strongPasswordCheckerII(String password) {
        if (password.length() < 8) return false;

        boolean isOneDigit = false;
        boolean isOneLow = false;
        boolean isOneUp = false;
        boolean isOneSpecial = false;
        char prev = 0;
        for (char c : password.toCharArray()) {
            if (!isOneDigit) isOneDigit = Character.isDigit(c);
            if (!isOneLow) isOneLow = Character.isLowerCase(c);
            if (!isOneUp) isOneUp = Character.isUpperCase(c);
            if (!isOneSpecial) isOneSpecial = special.contains(c);
            if (prev != 0 && prev == c) return false;
            prev = c;
        }

        return isOneDigit && isOneLow && isOneUp && isOneSpecial;
    }

}

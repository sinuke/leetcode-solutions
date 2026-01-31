package com.sinuke.easy;

public class GenerateStringWithCharactersThatHaveOddCounts {

    public String generateTheString(int n) {
        return "a".repeat(n - 1) + (n % 2 == 0 ? 'b' : 'a');
    }

}

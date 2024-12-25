package com.sinuke.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LetterCombinationsOfPhoneNumber {

    private final String[] keyboard = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.isEmpty()) return Collections.emptyList();
        var results = new ArrayList<String>();
        createCombinations(digits, 0, new StringBuilder(), results);
        return results;
    }

    private void createCombinations(String digits, int i, StringBuilder sb, List<String> results) {
        if (i == digits.length()) {
            results.add(sb.toString());
            return;
        }

        for (char c : keyboard[digits.charAt(i) - '0'].toCharArray()) {
            sb.append(c);
            createCombinations(digits, i + 1, sb, results);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

}

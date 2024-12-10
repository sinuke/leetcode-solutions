package com.sinuke;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class LetterCombinationsOfPhoneNumber {

    private final Map<Character, char[]> keyboard = Map.of(
            '2', new char[] { 'a', 'b', 'c' },
            '3', new char[] { 'd', 'e', 'f' },
            '4', new char[] { 'g', 'h', 'i' },
            '5', new char[] { 'j', 'k', 'l' },
            '6', new char[] { 'm', 'n', 'o' },
            '7', new char[] { 'p', 'q', 'r', 's' },
            '8', new char[] { 't', 'u', 'v' },
            '9', new char[] { 'w', 'x', 'y', 'z' }
    );

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.isEmpty()) return Collections.emptyList();
        var results = new ArrayList<>(List.of(""));

        for (var digit : digits.toCharArray()) {
            var tmp = new StringBuilder();
            for (var combination : results) {
                for (var letter : keyboard.get(digit)) tmp.append(combination).append(letter);
            }
            results.add(tmp.toString());
        }
        return results;
    }

}

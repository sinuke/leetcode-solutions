package com.sinuke.easy;

import java.util.Stack;

public class ReverseLettersThenSpecialCharactersInString {

    // 2 ms - 91%
    public String reverseByType(String s) {
        var sb = new StringBuilder();
        int si = s.length() - 1, li = s.length() - 1;
        for (int i = 0; i < s.length(); i++) {
            if (Character.isLetter(s.charAt(i))) {
                while (!Character.isLetter(s.charAt(li))) li--;
                sb.append(s.charAt(li--));
            } else {
                while (Character.isLetter(s.charAt(si))) si--;
                sb.append(s.charAt(si--));
            }
        }
        return sb.toString();
    }

    // 5 ms - 17%
    public String reverseByType2(String s) {
        Stack<Character> letters = new Stack<>();
        Stack<Character> special = new Stack<>();
        for (char c : s.toCharArray()) {
            if (Character.isLetter(c)) letters.push(c);
            else special.push(c);
        }

        var sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (Character.isLetter(c)) sb.append(letters.pop());
            else sb.append(special.pop());
        }

        return sb.toString();
    }

}

package com.sinuke.easy;

public class FindFirstPalindromicStringInArray {

    public String firstPalindrome(String[] words) {
        for (var word : words) {
            if (word.equals(reverse(word))) return word;
        }
        return "";
    }

    private String reverse(String word) {
        return new StringBuilder(word).reverse().toString();
    }

}

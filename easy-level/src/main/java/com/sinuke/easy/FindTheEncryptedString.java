package com.sinuke.easy;

public class FindTheEncryptedString {

    public String getEncryptedString(String s, int k) {
        char[] result = new char[s.length()];
        for (int i = 0; i < s.length(); i++) {
            result[i] = s.charAt(i + k > s.length() - 1 ? (i + k) % s.length() : i + k);
        }
        return new String(result);
    }

}

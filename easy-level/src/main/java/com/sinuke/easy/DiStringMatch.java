package com.sinuke.easy;

public class DiStringMatch {

    public int[] diStringMatch(String s) {
        int d = s.length(), i = 0;
        int[] result = new int[s.length() + 1];
        for (int j = 0; j < s.length(); j++) {
            if (s.charAt(j) == 'I') result[j] = i++;
            else result[j] = d--;
        }
        result[result.length - 1] = d;
        return result;
    }

}

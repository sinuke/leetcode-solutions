package com.sinuke.medium;

import java.util.ArrayList;
import java.util.List;

public class CamelcaseMatching {

    public List<Boolean> camelMatch(String[] queries, String pattern) {
        List<Boolean> result = new ArrayList<>(queries.length);
        for (String word : queries) result.add(isMatch(word, pattern));
        return result;
    }

    private boolean isMatch(String w, String p) {
        int i = 0, j = 0;
        while (i < w.length() || j < p.length()) {
            if (i < w.length() && j < p.length() && w.charAt(i) == p.charAt(j)) {
                i++;
                j++;
            } else if (i < w.length() && Character.isLowerCase(w.charAt(i))) i++;
            else return false;
        }
        return true;
    }

}

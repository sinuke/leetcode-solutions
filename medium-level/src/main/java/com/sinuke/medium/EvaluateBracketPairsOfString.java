package com.sinuke.medium;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EvaluateBracketPairsOfString {

    public String evaluate(String s, List<List<String>> knowledge) {
        Map<String, String> map = new HashMap<>();
        for (List<String> k : knowledge) {
            map.put(k.getFirst(), k.getLast());
        }

        var sb = new StringBuilder();
        var tmp = new StringBuilder();
        boolean key = false;
        for (char c : s.toCharArray()) {
            if (c == '(') key = true;
            else if (c == ')') {
                key = false;
                sb.append(map.getOrDefault(tmp.toString(), "?"));
                tmp.setLength(0);
            } else if (key) tmp.append(c);
            else sb.append(c);
        }

        if (!tmp.isEmpty()) sb.append(map.getOrDefault(tmp.toString(), "?"));

        return sb.toString();
    }

}

package com.sinuke.easy;

import java.util.HashMap;
import java.util.Map;

public class DecodeTheMessage {

    public String decodeMessage(String key, String message) {
        Map<Character, Character> map = new HashMap<>(26);

        int counter = 0;
        for (var ch : key.toCharArray()) {
            if (ch != ' ' && !map.containsKey(ch)) {
                map.put(ch, (char)(counter + 'a'));
                counter++;
            }
        }

        var sb = new StringBuilder();
        for (var ch : message.toCharArray()) {
            if (ch == ' ') sb.append(' ');
            else sb.append(map.get(ch));
        }

        return sb.toString();
    }

}

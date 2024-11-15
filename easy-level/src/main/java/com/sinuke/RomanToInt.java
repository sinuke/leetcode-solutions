package com.sinuke;

import java.util.Map;

public class RomanToInt {

    public int romanToInt(String s) {
        Map<Character, Integer> map = Map.of(
                'I', 1,
                'V', 5,
                'X', 10,
                'L', 50,
                'C', 100,
                'D', 500,
                'M', 1000
        );

        int result = 0;
        int i = s.length() - 1;
        while (i >= 0) {
            var c = s.charAt(i);
            var value = map.get(c);

            if (i > 0 && map.get(c) > map.get(s.charAt(i - 1))) {
                value -= map.get(s.charAt(i - 1));
                i--;
            }

            i--;
            result += value;
        }

        return result;
    }

}

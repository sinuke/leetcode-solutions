package com.sinuke;

import java.util.HashMap;
import java.util.Map;

public class IsomorphicStrings {

    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> map1 = new HashMap<>();
        Map<Character, Character> map2 = new HashMap<>();
        var result = true;
        var i = 0;
        
        while (i < s.length() && result) {
            var sChar = s.charAt(i);
            var tChar = t.charAt(i);
            
            if (!map1.containsKey(sChar) && !map2.containsKey(tChar)) {
                map1.put(sChar, tChar);
                map2.put(tChar, sChar);
            } else if (map1.containsKey(sChar) && !map2.containsKey(tChar)) result = false;
            else if (!map1.containsKey(sChar) && map2.containsKey(tChar)) result = false;
            else if (map1.containsKey(sChar) && map1.get(sChar) != tChar) result = false;
            else if (map2.containsKey(tChar) && map2.get(tChar) != sChar) result = false;
            
            i++;
        }
        
        return result;
    }
    
}

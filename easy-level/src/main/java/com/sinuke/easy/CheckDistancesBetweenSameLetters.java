package com.sinuke.easy;

import java.util.HashMap;
import java.util.Map;

public class CheckDistancesBetweenSameLetters {

    public boolean checkDistances(String s, int[] distance) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            int num = s.charAt(i) - 'a';
            if (map.containsKey(num)) {
                map.replace(num, i - map.get(num) - 1);
                if (map.get(num) != distance[num]) return false;
            }
            else map.put(num, i);
        }
        return true;
    }

}

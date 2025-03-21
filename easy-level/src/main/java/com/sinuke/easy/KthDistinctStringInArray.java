package com.sinuke.easy;

import java.util.HashMap;
import java.util.Map;

public class KthDistinctStringInArray {

    public String kthDistinct(String[] arr, int k) {
        Map<String, Integer> map = new HashMap<>();

        for (var str : arr) {
            map.put(str, map.getOrDefault(str, 0) + 1);
        }

        int counter = 0;
        for (var str : arr) {
            if (map.get(str) == 1) {
                counter++;
                if (counter == k) return str;
            }
        }

        return "";
    }

}

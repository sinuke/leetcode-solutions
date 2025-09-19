package com.sinuke.medium;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SortCharactersByFrequency {

    public String frequencySort(String s) {
        Map<Character, Stat> stats = new HashMap<>(62);
        List<Stat> list = new ArrayList<>(62);

        for (char c : s.toCharArray()) {
            if (!stats.containsKey(c)) {
                var stat = new Stat(c, 1);
                stats.put(c, stat);
                list.add(stat);
            } else stats.get(c).cnt++;
        }

        list.sort(Comparator.<Stat>comparingInt(stat -> stat.cnt).reversed().thenComparing(stat -> stat.c));

        var sb = new StringBuilder();
        for (var stat : list) sb.repeat(stat.c, stat.cnt);
        return sb.toString();
    }

    private static class Stat {
        char c;
        int cnt;

        Stat(char c, int cnt) {
            this.c = c;
            this.cnt = cnt;
        }
    }

}

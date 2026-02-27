package com.sinuke.easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FindTheTownJudge {

    // 3 ms
    public int findJudge(int n, int[][] trust) {
        if (n == 1) return 1;

        int[] counts = new int[n + 1];
        int[] used = new int[n + 1];

        int answer = 0;
        for (int[] relation : trust) {
            counts[relation[1]]++;
            used[relation[0]] = 1;
            if (counts[relation[1]] == n - 1) answer = relation[1];
        }

        return answer > 0 && used[answer] == 0 ? answer : -1;
    }

    // 38 ms
    public int findJudge2(int n, int[][] trust) {
        if (n == 1) return 1;

        Map<Integer, Set<Integer>> map = new HashMap<>(n + 1);
        Set<Integer> set = new HashSet<>(n + 1);

        int answer = 0;
        for (int[] relation : trust) {
            map.putIfAbsent(relation[1], new HashSet<>(n + 1));
            map.get(relation[1]).add(relation[0]);
            set.add(relation[0]);
            if (map.get(relation[1]).size() == n - 1) answer = relation[1];
        }

        return answer > 0 && !set.contains(answer) ? answer : -1;
    }

}

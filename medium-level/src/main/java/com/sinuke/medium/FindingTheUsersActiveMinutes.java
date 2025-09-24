package com.sinuke.medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FindingTheUsersActiveMinutes {

    public int[] findingUsersActiveMinutes(int[][] logs, int k) {
        Map<Integer, Set<Integer>> map = new HashMap<>(10_000);
        int[] answer = new int[k];

        for (int[] user : logs) {
            int id = user[0];
            int time = user[1];

            if (map.containsKey(id)) answer[map.get(id).size() - 1]--;
            else map.put(id, new HashSet<>());
            map.get(id).add(time);

            answer[map.get(id).size() - 1]++;
        }

        return answer;
    }

}

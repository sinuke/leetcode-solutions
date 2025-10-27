package com.sinuke.medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class FindPlayersWithZeroOrOneLosses {

    public List<List<Integer>> findWinners(int[][] matches) {
        Map<Integer, Integer> map = new HashMap<>(2 * matches.length);
        Set<Integer> noLose = new HashSet<>(matches.length);
        Set<Integer> oneLose = new HashSet<>(matches.length);

        for (int[] match : matches) {
            if (!map.containsKey(match[0])) {
                map.put(match[0], 0);
                noLose.add(match[0]);
            }

            map.put(match[1], map.getOrDefault(match[1], 0) + 1);

            noLose.remove(match[1]);
            if (map.get(match[1]) == 1) oneLose.add(match[1]);
            else if (map.get(match[1]) > 1) oneLose.remove(match[1]);
        }

        return List.of(
                noLose.stream().sorted().toList(),
                oneLose.stream().sorted().toList()
        );
    }

}

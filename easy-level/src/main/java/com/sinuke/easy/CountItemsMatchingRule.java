package com.sinuke.easy;

import java.util.List;
import java.util.Map;

public class CountItemsMatchingRule {

    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        Map<String, Integer> indx = Map.of(
                "type", 0,
                "color", 1,
                "name", 2
        );

        int index = indx.getOrDefault(ruleKey, 0);
        int count = 0;

        for (List<String> item : items) {
            if (ruleValue.equals(item.get(index))) count++;
        }

        return count;
    }

}

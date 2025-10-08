package com.sinuke.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindDuplicateFileInSystem {

    public List<List<String>> findDuplicate(String[] paths) {
        Map<String, List<String>> map = new HashMap<>();
        for (var path : paths) {
            var split = path.split(" ");
            for (int i = 1; i < split.length; i++) {
                var p = split[i];
                int s = p.indexOf("(");
                var content = p.substring(s + 1, p.length() - 1);
                var fileName = String.format("%s/%s", split[0], p.substring(0, s));

                map.putIfAbsent(content, new ArrayList<>());
                map.get(content).add(fileName);
            }
        }


        return new ArrayList<>(map.values());
    }

}

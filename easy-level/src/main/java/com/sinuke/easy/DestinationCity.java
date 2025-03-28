package com.sinuke.easy;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DestinationCity {

    public String destCity(List<List<String>> paths) {
        Set<String> sources = new HashSet<>();
        Set<String> destinations = new HashSet<>();

        for (List<String> path : paths) {
            sources.add(path.getFirst());
            destinations.add(path.get(1));
        }

        destinations.removeAll(sources);

        return destinations.toArray(new String[1])[0];
    }

}

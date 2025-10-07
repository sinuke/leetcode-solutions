package com.sinuke.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class DisplayTableOfFoodOrdersInRestaurant {

    public List<List<String>> displayTable(List<List<String>> orders) {
        Map<Integer, Map<String, Integer>> tables = new HashMap<>();
        Set<String> foodSet = new HashSet<>();
        Set<Integer> tableSet = new HashSet<>();

        for (var order : orders) {
            int table = Integer.parseInt(order.get(1));
            String food = order.get(2);

            tables.putIfAbsent(table, new HashMap<>());
            var t = tables.get(table);
            t.put(food, t.getOrDefault(food, 0) + 1);

            foodSet.add(food);
            tableSet.add(table);
        }

        List<String> foodNames = foodSet.stream().sorted().toList();
        List<Integer> tableNumbers = tableSet.stream().sorted().toList();

        List<List<String>> result = new ArrayList<>(tables.size() + 1);
        List<String> header = new ArrayList<>(foodNames.size() + 1);
        header.add("Table");
        header.addAll(foodNames);
        result.add(header);

        for (int tableNumber : tableNumbers) {
            List<String> line = new ArrayList<>(foodNames.size() + 1);
            line.add(String.valueOf(tableNumber));
            Map<String, Integer> table = tables.get(tableNumber);

            for (var food : foodNames) {
                line.add(String.valueOf(table.getOrDefault(food, 0)));
            }

            result.add(line);
        }

        return result;
    }

}

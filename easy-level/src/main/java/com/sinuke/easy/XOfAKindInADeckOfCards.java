package com.sinuke.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class XOfAKindInADeckOfCards {

    public boolean hasGroupsSizeX(int[] deck) {
        if (deck.length == 1) return false;

        Map<Integer, Integer> map = new HashMap<>();
        for (int i : deck) map.put(i, map.getOrDefault(i, 0) + 1);

        List<Integer> lst = new ArrayList<>(map.values());
        for (int i = 0; i < lst.size() - 1; i++) {
            for (int j = i + 1; j < lst.size(); j++) {
                if (gcd(lst.get(i), lst.get(j)) == 1) return false;
            }
        }

        return true;
    }

    private int gcd (int a, int b) {
        while (b > 0) {
            a %= b;
            int c = a;
            a = b;
            b = c;
        }
        return a;
    }

}

package com.sinuke.easy;

import java.util.ArrayList;
import java.util.List;

public class ToggleLightBulbs {

    public List<Integer> toggleLightBulbs(List<Integer> bulbs) {
        int[] states = new int[101];
        for (int num : bulbs) states[num] = states[num] == 0 ? 1 : 0;

        List<Integer> result = new ArrayList<>(bulbs.size());
        for (int i = 1; i < states.length; i++) {
            if (states[i] == 1) result.add(i);
        }
        return result;
    }

}

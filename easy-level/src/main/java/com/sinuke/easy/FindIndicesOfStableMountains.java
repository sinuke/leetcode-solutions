package com.sinuke.easy;

import java.util.ArrayList;
import java.util.List;

public class FindIndicesOfStableMountains {

    public List<Integer> stableMountains(int[] height, int threshold) {
        List<Integer> result = new ArrayList<>(height.length - 1);

        for (int i = 1; i < height.length; i++) {
            if (height[i - 1] > threshold) result.add(i);
        }

        return result;
    }

}

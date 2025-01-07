package com.sinuke.easy;

import java.util.ArrayList;
import java.util.List;

public class KidsWithGreatestNumberOfCandies {

    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = Integer.MIN_VALUE;
        for (int candy : candies)
            max = Math.max(max, candy);

        List<Boolean> result = new ArrayList<>();
        for (int candy : candies)
            result.add(candy + extraCandies >= max);
        return result;
    }

}

package com.sinuke.easy;

public class DistributeCandiesToPeople {

    public int[] distributeCandies(int candies, int num_people) {
        int[] result = new int[num_people];
        int c = 0, i = 0, sum = 0;
        while (sum < candies) {
            if (sum + c + 1 > candies) c = candies - sum;
            else c++;
            result[i] += c;
            sum += c;

            if (i == result.length - 1) i = 0;
            else i++;
        }
        return result;
    }

}

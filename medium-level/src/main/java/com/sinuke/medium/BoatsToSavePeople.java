package com.sinuke.medium;

import java.util.Arrays;

public class BoatsToSavePeople {

    // 20 ms
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int i = 0, j = people.length - 1, cnt = 0;
        while (i < j) {
            if (people[i] + people[j] <= limit) i++;
            j--;
            cnt++;
        }
        return i == j ? cnt + 1 : cnt;
    }

}

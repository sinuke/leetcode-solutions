package com.sinuke.easy;

import java.util.HashSet;
import java.util.Set;

public class RestoreFinishingOrder {

    public int[] recoverOrder(int[] order, int[] friends) {
        Set<Integer> set = new HashSet<>(friends.length);
        for (int friend : friends) set.add(friend);

        int k = 0;
        for (int o : order) {
            if (set.contains(o)) friends[k++] = o;
        }

        return friends;
    }

}

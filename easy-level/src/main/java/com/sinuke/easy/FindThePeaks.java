package com.sinuke.easy;

import java.util.ArrayList;
import java.util.List;

public class FindThePeaks {

    public List<Integer> findPeaks(int[] mountain) {
        List<Integer> list = new ArrayList<>(mountain.length - 2);
        for (int i = 1; i < mountain.length - 1; i++) {
            if (mountain[i] > mountain[i - 1] && mountain[i] > mountain[i + 1]) list.add(i);
        }
        return list;
    }

}

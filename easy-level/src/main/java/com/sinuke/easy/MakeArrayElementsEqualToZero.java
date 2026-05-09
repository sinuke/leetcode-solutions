package com.sinuke.easy;

import java.util.ArrayList;
import java.util.List;

public class MakeArrayElementsEqualToZero {

    // 1 ms
    public int countValidSelections(int[] nums) {
        int n = nums.length;

        int[] sl = new int[n];
        int[] sr = new int[n];
        List<Integer> zeroes = new ArrayList<>(n);

        if (nums[0] == 0) zeroes.add(0);
        sl[0] = nums[0];
        sr[n - 1] = nums[n - 1];

        for (int i = 1; i < n; i++) {
            sl[i] = sl[i - 1] + nums[i];
            sr[n - i - 1] = sr[n - i] + nums[n - i - 1];
            if (nums[i] == 0) zeroes.add(i);
        }

        int cnt = 0;
        for (int i : zeroes) {
            if (sl[i] == sr[i]) cnt += 2;
            else if (Math.abs(sl[i] - sr[i]) == 1) cnt++;
        }

        return cnt;
    }

    // 1 ms
    public int countValidSelections2(int[] nums) {
        int n = nums.length;

        int[] sl = new int[n];
        int[] sr = new int[n];

        sl[0] = nums[0];
        sr[n - 1] = nums[n - 1];
        for (int i = 1; i < n; i++) {
            sl[i] = sl[i - 1] + nums[i];
            sr[n - i - 1] = sr[n - i] + nums[n - i - 1];
        }

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0 && sl[i] == sr[i]) cnt += 2;
            else if (nums[i] == 0 && Math.abs(sl[i] - sr[i]) == 1) cnt++;
        }

        return cnt;
    }

}

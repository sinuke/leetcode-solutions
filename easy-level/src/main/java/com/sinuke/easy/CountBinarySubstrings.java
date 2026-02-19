package com.sinuke.easy;

import java.util.ArrayList;
import java.util.List;

public class CountBinarySubstrings {

    // 12 ms
    public int countBinarySubstrings(String s) {
        List<Integer> counts = new ArrayList<>(s.length());
        int cnt = 1;
        char prev = s.charAt(0);

        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c != prev) {
                counts.add(cnt);
                cnt = 1;
            } else cnt++;
            prev = c;
        }
        counts.add(cnt);

        cnt = 0;
        for (int i = 1; i < counts.size(); i++) {
            cnt += Math.min(counts.get(i - 1), counts.get(i));
        }

        return cnt;
    }

    // 9 ms
    public int countBinarySubstrings2(String s) {
        int currentCount = 1, prevCount = 0, answer = 0;
        char prev = s.charAt(0);

        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c != prev) {
                answer += Math.min(currentCount, prevCount);
                prevCount = currentCount;
                currentCount = 1;
            } else currentCount++;
            prev = c;
        }
        answer += Math.min(currentCount, prevCount);

        return answer;
    }

}

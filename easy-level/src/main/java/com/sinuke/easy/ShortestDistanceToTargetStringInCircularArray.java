package com.sinuke.easy;

public class ShortestDistanceToTargetStringInCircularArray {

    public int closestTarget(String[] words, String target, int startIndex) {
        if (target.equals(words[startIndex])) return 0;

        int right = 0, n = words.length, i = startIndex;
        while (right < n && !target.equals(words[i])) {
            right++;
            i = (i + 1) % n;
        }

        int left = 0;
        i = startIndex;
        while (left < n && !target.equals(words[i])) {
            left++;
            i = (i - 1 + n) % n;
        }

        return (right == 0 || left == 0 || left == n || right == n) ? -1 : Math.min(left, right);
    }

}

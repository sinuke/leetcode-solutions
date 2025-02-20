package com.sinuke.medium;

import java.util.HashMap;
import java.util.Map;

public class FindUniqueBinaryString {

    private final Map<String, Integer> map = new HashMap<>();
    private final char[] chars = new char[] {'0', '1'};

    // slow - 487 ms
    public String findDifferentBinaryString(String[] nums) {
        for (var num : nums) map.put(num, map.getOrDefault(num, 0) + 1);

        backtrack(nums[0].length(), "");

        return map.entrySet()
                .stream()
                .filter(e -> e.getValue() == 1)
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse("");
    }

    private void backtrack(int n, String str) {
        if (str.length() == n) map.put(str, map.getOrDefault(str, 0) + 1);
        else for (var c : chars) backtrack(n, str + c);
    }

    // faster - 3 ms
    public String findDifferentBinaryString2(String[] nums) {
        int n = nums[0].length();
        int min = 0;

        byte[] flags = new byte[65536];
        for (var num : nums) flags[Integer.parseInt(num, 2)] = 1;

        while (flags[min] != 0) min++;

        var result = Integer.toBinaryString(min);
        if (result.length() < n) result = "0".repeat(n - result.length()) + result;
        return result;
    }

}

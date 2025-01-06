package com.sinuke.medium;

public class MinimumNumbeOfOperationsToMoveAllBallsToEachBox {

    // 63 ms
    public int[] minOperations(String boxes) {
        var chars = boxes.toCharArray();
        var result = new int[chars.length];

        for (var i = 0; i < chars.length; i++) {
            for (var j = 0; j < chars.length; j++) {
                if (chars[j] == '1') result[i] += Math.abs(i - j);
            }
        }

        return result;
    }

}

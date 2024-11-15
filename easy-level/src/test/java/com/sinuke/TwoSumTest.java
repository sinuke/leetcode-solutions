package com.sinuke;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class TwoSumTest {

    @Test
    void twoSum() {
        var twoSum = new TwoSum();

        assertArrayEquals(new int[] {1, 0}, twoSum.twoSum(new int[] {2, 7, 11, 15}, 9));
        assertArrayEquals(new int[] {2, 1}, twoSum.twoSum(new int[] {3,2,4}, 6));
        assertArrayEquals(new int[] {1, 0}, twoSum.twoSum(new int[] {3, 3}, 6));
    }

}

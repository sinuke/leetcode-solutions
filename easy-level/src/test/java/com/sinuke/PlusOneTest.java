package com.sinuke;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class PlusOneTest {

    @Test
    void plusOne() {
        var plusOne = new PlusOne();

        assertArrayEquals(new int[] {1, 2, 4}, plusOne.plusOne(new int[] {1, 2, 3}));
        assertArrayEquals(new int[] {1, 0 ,0}, plusOne.plusOne(new int[] {9, 9}));
    }

}

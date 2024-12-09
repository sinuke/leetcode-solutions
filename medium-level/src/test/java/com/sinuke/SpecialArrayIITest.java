package com.sinuke;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SpecialArrayIITest {

    @ParameterizedTest
    @MethodSource("testData")
    void isArraySpecial(int[] nums, int[][] queries, boolean[] expected) {
        var specialArray = new SpecialArrayII();

        assertArrayEquals(expected, specialArray.isArraySpecial(nums, queries));
        assertArrayEquals(expected, specialArray.isArraySpecialFromLeetCode(nums, queries));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[] {3, 4, 1, 2, 6}, new int[][] {{0, 4}}, new boolean[]{false}),
                Arguments.of(new int[] {4, 3, 1, 6}, new int[][] {{0, 2}, {2, 3}}, new boolean[]{false, true}),
                Arguments.of(new int[] {1}, new int[][] {{0, 0}}, new boolean[]{true}),
                Arguments.of(new int[] {7, 7}, new int[][] {{1, 1}}, new boolean[]{true})
        );
    }

}

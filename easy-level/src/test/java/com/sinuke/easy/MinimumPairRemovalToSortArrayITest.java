package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MinimumPairRemovalToSortArrayITest {

    @ParameterizedTest
    @MethodSource("testData")
    void minimumPairRemoval(int[] nums, int expected) {
        var solution = new MinimumPairRemovalToSortArrayI();
        assertEquals(expected, solution.minimumPairRemoval(nums));
        assertEquals(expected, solution.minimumPairRemoval2(nums));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[]{5, 2, 3, 1}, 2),
                Arguments.of(new int[]{1, 2, 2}, 0)
        );
    }

}

package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LargestNumberAtLeastTwiceOfOthersTest {

    @ParameterizedTest
    @MethodSource("testData")
    void dominantIndex(int[] nums, int expected) {
        assertEquals(expected, new LargestNumberAtLeastTwiceOfOthers().dominantIndex(nums));
        assertEquals(expected, new LargestNumberAtLeastTwiceOfOthers().dominantIndex2(nums));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[] {3, 6, 1, 0}, 1),
                Arguments.of(new int[] {1, 2, 3, 4}, -1)
        );
    }

}

package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MostFrequentNumberFollowingKeyInArrayTest {

    @ParameterizedTest
    @MethodSource("testData")
    void mostFrequent(int[] nums, int key, int expected) {
        assertEquals(expected, new MostFrequentNumberFollowingKeyInArray().mostFrequent(nums, key));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[] {1, 100, 200, 1, 100}, 1, 100),
                Arguments.of(new int[] {2, 2, 2, 2, 3}, 2, 2)
        );
    }

}

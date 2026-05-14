package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CheckIfArrayIsGoodTest {

    @ParameterizedTest
    @MethodSource("testData")
    void isGood(int[] nums, boolean expected) {
        assertEquals(expected, new CheckIfArrayIsGood().isGood(nums));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[]{2, 1, 3}, false),
                Arguments.of(new int[]{1, 3, 3, 2}, true),
                Arguments.of(new int[]{1, 1}, true),
                Arguments.of(new int[]{3, 4, 4, 1, 2, 1}, false)
        );
    }

}

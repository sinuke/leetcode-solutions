package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UniqueMiddleElementTest {

    @ParameterizedTest
    @MethodSource("testData")
    void isMiddleElementUnique(int[] nums, boolean expected) {
        assertEquals(expected, new UniqueMiddleElement().isMiddleElementUnique(nums));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 3}, true),
                Arguments.of(new int[]{1, 2, 2}, false)
        );
    }

}

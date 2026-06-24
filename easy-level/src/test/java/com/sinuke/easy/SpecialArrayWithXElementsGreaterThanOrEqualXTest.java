package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.of;

class SpecialArrayWithXElementsGreaterThanOrEqualXTest {

    @ParameterizedTest
    @MethodSource("testData")
    void specialArray(int[] nums, int expected) {
        assertEquals(expected, new SpecialArrayWithXElementsGreaterThanOrEqualX().specialArray(nums));
    }

    private static Stream<org.junit.jupiter.params.provider.Arguments> testData() {
        return Stream.of(
                of(new int[]{3, 5}, 2),
                of(new int[]{0, 0}, -1),
                of(new int[]{0, 4, 3, 0, 4}, 3)
        );
    }
}

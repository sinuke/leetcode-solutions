package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ThirdMaximumNumberTest {

    @ParameterizedTest
    @MethodSource("testData")
    void thirdMax(int[] nums, int expected) {
        var thirdMaxNumber = new ThirdMaximumNumber();
        assertEquals(expected, thirdMaxNumber.thirdMax(nums));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[] {3, 2, 1}, 1),
                Arguments.of(new int[] {1, 2}, 2),
                Arguments.of(new int[] {1}, 1),
                Arguments.of(new int[] {2, 2, 3, 1}, 1),
                Arguments.of(new int[] {-2147483648}, -2147483648),
                Arguments.of(new int[] {-2147483648, -2147483647, -2147483648}, -2147483647),
                Arguments.of(new int[] {1, 2, -2147483648}, -2147483648)
        );
    }

}

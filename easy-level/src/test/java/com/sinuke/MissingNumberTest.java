package com.sinuke;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MissingNumberTest {

    @ParameterizedTest
    @MethodSource("testData")
    void missingNumber(int[] nums, int expected) {
        var missingNumber = new MissingNumber();
        assertEquals(expected, missingNumber.missingNumber(nums));
        assertEquals(expected, missingNumber.missingNumber2(nums));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[] {3, 0, 1}, 2),
                Arguments.of(new int[] {0, 1}, 2),
                Arguments.of(new int[] {9, 6, 4, 2, 3, 5, 7, 0, 1}, 8),
                Arguments.of(new int[] {0}, 1)
        );
    }

}

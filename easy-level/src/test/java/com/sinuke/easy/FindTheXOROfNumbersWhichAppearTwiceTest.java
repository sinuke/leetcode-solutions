package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FindTheXOROfNumbersWhichAppearTwiceTest {

    @ParameterizedTest
    @MethodSource("testData")
    void duplicateNumbersXOR(int[] nums, int expected) {
        var solution = new FindTheXOROfNumbersWhichAppearTwice();
        assertEquals(expected, solution.duplicateNumbersXOR(nums));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[] {1,2,1,3}, 1),
                Arguments.of(new int[] {1,2,3}, 0),
                Arguments.of(new int[] {1,2,2,1}, 3)
        );
    }

}

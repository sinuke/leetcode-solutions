package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;


class MakeArrayElementsEqualToZeroTest {

    @ParameterizedTest
    @MethodSource("testData")
    void countValidSelections(int[] nums, int expected) {
        var solution = new MakeArrayElementsEqualToZero();
        assertEquals(expected, solution.countValidSelections(nums));
        assertEquals(expected, solution.countValidSelections2(nums));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[]{1, 0, 2, 0, 3}, 2),
                Arguments.of(new int[]{2, 3, 4, 0, 4, 1, 0}, 0),
                Arguments.of(new int[]{0}, 2),
                Arguments.of(new int[]{0, 0, 0, 0, 0, 0, 0, 0}, 16)
        );
    }

}

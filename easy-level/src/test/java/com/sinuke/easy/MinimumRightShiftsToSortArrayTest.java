package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MinimumRightShiftsToSortArrayTest {

    @ParameterizedTest
    @MethodSource("testData")
    void test(List<Integer> nums, int expected) {
        var solution = new MinimumRightShiftsToSortArray();
        assertEquals(expected, solution.minimumRightShifts(nums));
    }

    static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(List.of(3, 4, 5, 1, 2), 2),
                Arguments.of(List.of(1, 3, 5), 0),
                Arguments.of(List.of(2, 1, 4), -1)
        );
    }

}

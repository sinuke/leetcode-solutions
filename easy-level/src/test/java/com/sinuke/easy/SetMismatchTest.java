package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SetMismatchTest {

    @ParameterizedTest
    @MethodSource("testData")
    void findErrorNums(int[] nums, int[] expected) {
        var solution = new SetMismatch();
        assertArrayEquals(expected, solution.findErrorNums(nums));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[] {1,2,2,4}, new int[] {2,3}),
                Arguments.of(new int[] {1,1}, new int[] {1,2})
        );
    }

}

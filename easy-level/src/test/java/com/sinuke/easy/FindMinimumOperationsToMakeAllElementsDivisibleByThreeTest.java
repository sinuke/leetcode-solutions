package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FindMinimumOperationsToMakeAllElementsDivisibleByThreeTest {

    @ParameterizedTest
    @MethodSource("testData")
    void minimumOperations(int[] nums, int expected) {
        var finder = new FindMinimumOperationsToMakeAllElementsDivisibleByThree();
        assertEquals(expected, finder.minimumOperations(nums));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[] {1,2,3,4}, 3),
                Arguments.of(new int[] {3,6,9}, 0)
        );
    }

}

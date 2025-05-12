package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertTrue;

class NeitherMinimumNorMaximumTest {

    @ParameterizedTest
    @MethodSource("testData")
    void findNonMinOrMax(int[] nums, List<Integer> expected) {
        var solution = new NeitherMinimumNorMaximum();
        assertTrue(expected.contains(solution.findNonMinOrMax(nums)));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[] {3,2,1,4}, List.of(2, 3)),
                Arguments.of(new int[] {1, 2}, List.of(-1)),
                Arguments.of(new int[] {2,1,3}, List.of(2))
        );
    }

}

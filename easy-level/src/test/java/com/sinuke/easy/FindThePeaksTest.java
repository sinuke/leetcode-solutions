package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FindThePeaksTest {

    @ParameterizedTest
    @MethodSource("testData")
    void findPeaks(int[] nums, List<Integer> expected) {
        var solution = new FindThePeaks();
        assertEquals(expected, solution.findPeaks(nums));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[] {2,4,4}, List.of()),
                Arguments.of(new int[] {1,4,3,8,5}, List.of(1, 3))
        );
    }

}

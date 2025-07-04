package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LastVisitedIntegersTest {

    @ParameterizedTest
    @MethodSource("testData")
    void lastVisitedIntegers(int[] nums, List<Integer> expected) {
        var solution = new LastVisitedIntegers();
        assertEquals(expected, solution.lastVisitedIntegers(nums));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[] {1,2,-1,-1,-1}, List.of(2,1,-1)),
                Arguments.of(new int[] {1,-1,2,-1,-1}, List.of(1,2,1))
        );
    }

}

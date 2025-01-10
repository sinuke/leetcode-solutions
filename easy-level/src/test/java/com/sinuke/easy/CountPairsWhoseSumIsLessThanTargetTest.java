package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CountPairsWhoseSumIsLessThanTargetTest {

    @ParameterizedTest
    @MethodSource("testData")
    void countPairs(List<Integer> nums, int target, int expected) {
        var counter = new CountPairsWhoseSumIsLessThanTarget();
        assertEquals(expected, counter.countPairs(nums, target));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(List.of(-1,1,2,3,1), 2, 3),
                Arguments.of(List.of(-6,2,5,-2,-7,-1,3), -2, 10)
        );
    }

}
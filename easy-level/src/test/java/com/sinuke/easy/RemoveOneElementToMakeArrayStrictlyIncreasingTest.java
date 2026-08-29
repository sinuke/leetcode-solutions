package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RemoveOneElementToMakeArrayStrictlyIncreasingTest {

    @ParameterizedTest
    @MethodSource("testData")
    void canBeIncreasing(int[] nums, boolean expected) {
        var checker = new RemoveOneElementToMakeArrayStrictlyIncreasing();
        assertEquals(expected, checker.canBeIncreasing(nums));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[] {1,2,10,5,7}, true),
                Arguments.of(new int[] {2,3,1,2}, false),
                Arguments.of(new int[] {1,1,1}, false)
        );
    }

}

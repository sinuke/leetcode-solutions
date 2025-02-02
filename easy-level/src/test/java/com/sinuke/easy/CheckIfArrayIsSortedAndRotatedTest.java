package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CheckIfArrayIsSortedAndRotatedTest {

    @ParameterizedTest
    @MethodSource("testData")
    void check(int nums[], boolean expected) {
        var checker = new CheckIfArrayIsSortedAndRotated();
        assertEquals(expected, checker.check(nums));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[] {3,4,5,1,2}, true),
                Arguments.of(new int[] {2,1,3,4}, false),
                Arguments.of(new int[] {1,2,3}, true),
                Arguments.of(new int[] {5,5,6,6,6,9,1,2}, true),
                Arguments.of(new int[] {10,1,4,5,10}, true)
        );
    }

}

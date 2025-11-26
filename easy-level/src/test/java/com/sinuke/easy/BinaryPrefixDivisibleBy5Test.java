package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BinaryPrefixDivisibleBy5Test {

    @ParameterizedTest
    @MethodSource("testData")
    void prefixesDivBy5(int[] nums, List<Boolean> expected) {
        var solution = new BinaryPrefixDivisibleBy5();
        assertEquals(expected, solution.prefixesDivBy5(nums));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[] {0,1,1}, List.of(true,false,false)),
                Arguments.of(new int[] {1,1,1}, List.of(false,false,false))
        );
    }

}

package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CheckIfBinaryStringHasAtMostOneSegmentOfOnesTest {

    @ParameterizedTest
    @MethodSource("testData")
    void checkOnesSegment(String s, boolean expected) {
        var solution = new CheckIfBinaryStringHasAtMostOneSegmentOfOnes();
        assertEquals(expected, solution.checkOnesSegment(s));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("1001", false),
                Arguments.of("110", true),
                Arguments.of("1", true),
                Arguments.of("10", true)
        );
    }

}

package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NumberOfSegmentsInStringTest {

    @ParameterizedTest
    @MethodSource("testData")
    void countSegments(String s, int expected) {
        var solution = new NumberOfSegmentsInString();
        assertEquals(expected, solution.countSegments(s));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("Hello, my name is John", 5),
                Arguments.of("Hello", 1)
        );
    }

}

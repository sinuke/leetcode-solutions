package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SplitStringsBySeparatorTest {

    @ParameterizedTest
    @MethodSource("testData")
    void splitWordsBySeparator(List<String> words, char separator, List<String> expected) {
        var solution = new SplitStringsBySeparator();
        assertEquals(expected, solution.splitWordsBySeparator(words, separator));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(List.of("one.two.three","four.five","six"), '.', List.of("one","two","three","four","five","six")),
                Arguments.of(List.of("$easy$","$problem$"), '$', List.of("easy","problem")),
                Arguments.of(List.of("|||"), '|', List.of())
        );
    }

}

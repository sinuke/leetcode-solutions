package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PermutationDifferenceBetweenTwoStringsTest {

    @ParameterizedTest
    @MethodSource("testData")
    void findPermutationDifference(String s, String t, int expected) {
        var finder = new PermutationDifferenceBetweenTwoStrings();
        assertEquals(expected, finder.findPermutationDifference(s, t));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("abc", "bac", 2),
                Arguments.of("abcde", "edbac", 12)
        );
    }

}

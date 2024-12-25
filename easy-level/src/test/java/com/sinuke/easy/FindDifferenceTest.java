package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FindDifferenceTest {

    @ParameterizedTest
    @MethodSource("testData")
    void findTheDifference(String s, String t, char expected) {
        var findDifference = new FindDifference();
        assertEquals(expected, findDifference.findTheDifference(s, t));
        assertEquals(expected, findDifference.findTheDifference2(s, t));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("abcd", "abcde", 'e'),
                Arguments.of("", "y", 'y')
        );
    }

}

package com.sinuke;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AddingSpacesToStringTest {

    @ParameterizedTest
    @MethodSource("testData")
    void addSpaces(String input, int[] spaces, String expected) {
        var addingSpacesToString = new AddingSpacesToString();
        assertEquals(expected, addingSpacesToString.addSpaces(input, spaces));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("LeetcodeHelpsMeLearn", new int[] {8, 13, 15}, "Leetcode Helps Me Learn"),
                Arguments.of("icodeinpython", new int[] {1, 5, 7, 9}, "i code in py thon"),
                Arguments.of("spacing", new int[] {0, 1, 2, 3, 4, 5, 6}, " s p a c i n g")
        );
    }

}

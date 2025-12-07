package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RearrangeSpacesBetweenWordsTest {

    @ParameterizedTest
    @MethodSource("testData")
    void reorderSpaces(String text, String expected) {
        var solution = new RearrangeSpacesBetweenWords();
        assertEquals(expected, solution.reorderSpaces(text));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("  this   is  a sentence ", "this   is   a   sentence"),
                Arguments.of(" practice   makes   perfect", "practice   makes   perfect ")
        );
    }

}

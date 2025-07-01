package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FindTheOriginalTypedStringITest {

    @ParameterizedTest
    @MethodSource("testData")
    void possibleStringCount(String word, int expected) {
        var solution =  new FindTheOriginalTypedStringI();
        assertEquals(expected, solution.possibleStringCount(word));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("abbcccc", 5),
                Arguments.of("abcd", 1),
                Arguments.of("aaaa", 4)
        );
    }

}

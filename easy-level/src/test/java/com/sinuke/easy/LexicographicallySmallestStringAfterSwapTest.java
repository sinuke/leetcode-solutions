package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LexicographicallySmallestStringAfterSwapTest {

    @ParameterizedTest
    @MethodSource("testData")
    void getSmallestString(String s, String expected) {
        var solution = new LexicographicallySmallestStringAfterSwap();
        assertEquals(expected, solution.getSmallestString(s));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("45320", "43520"),
                Arguments.of("001", "001")
        );
    }

}

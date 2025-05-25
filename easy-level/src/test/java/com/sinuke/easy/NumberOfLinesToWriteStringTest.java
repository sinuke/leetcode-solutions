package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class NumberOfLinesToWriteStringTest {

    @ParameterizedTest
    @MethodSource("testData")
    void numberOfLines(int[] widths, String s, int[] expected) {
        var solution = new NumberOfLinesToWriteString();
        assertArrayEquals(expected, solution.numberOfLines(widths, s));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(
                        new int[] {10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10},
                        "abcdefghijklmnopqrstuvwxyz",
                        new int[] {3, 60}
                ),
                Arguments.of(
                        new int[] {4,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10},
                        "bbbcccdddaaa",
                        new int[] {2, 4}
                )
        );
    }

}

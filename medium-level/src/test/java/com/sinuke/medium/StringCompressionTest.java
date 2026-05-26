package com.sinuke.medium;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StringCompressionTest {

    @ParameterizedTest
    @MethodSource("testData")
    void compress(char[] chars, int expected) {
        assertEquals(expected, new StringCompression().compress(chars));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new char[]{'a', 'a', 'b', 'b', 'c', 'c', 'c'}, 6),
                Arguments.of(new char[]{'a'}, 1),
                Arguments.of(new char[]{'a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b'}, 4)
        );
    }

}

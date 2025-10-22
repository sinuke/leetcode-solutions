package com.sinuke.medium;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StringCompressionIIITest {

    @ParameterizedTest
    @MethodSource("testData")
    void compressedString(String word, String expected) {
        var solution = new StringCompressionIII();
        assertEquals(expected, solution.compressedString(word));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("abcde", "1a1b1c1d1e"),
                Arguments.of("aaaaaaaaaaaaaabb", "9a5a2b")
        );
    }

}

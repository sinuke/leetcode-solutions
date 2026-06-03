package com.sinuke.medium;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LexicographicallySmallestStringAfterReverseTest {

    @ParameterizedTest
    @MethodSource("testData")
    void lexSmallest(String s, String expected) {
        assertEquals(expected, new LexicographicallySmallestStringAfterReverse().lexSmallest(s));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("dcab", "acdb"),
                Arguments.of("abba", "aabb"),
                Arguments.of("zxy", "xzy")
        );
    }

}

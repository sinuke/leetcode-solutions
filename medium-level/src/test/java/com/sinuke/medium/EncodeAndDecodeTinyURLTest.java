package com.sinuke.medium;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EncodeAndDecodeTinyURLTest {

    @ParameterizedTest
    @MethodSource("testData")
    void codecTest(String longUrl, String expected) {
        var solution = new EncodeAndDecodeTinyURL.Codec();
        assertEquals(expected, solution.decode(solution.encode(longUrl)));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("https://leetcode.com/problems/design-tinyurl", "https://leetcode.com/problems/design-tinyurl")
        );
    }

}

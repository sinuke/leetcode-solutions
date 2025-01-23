package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DecodeTheMessageTest {

    @ParameterizedTest
    @MethodSource("testData")
    void decodeMessage(String key, String message, String expected) {
        var decoder = new DecodeTheMessage();
        assertEquals(expected, decoder.decodeMessage(key, message));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("the quick brown fox jumps over the lazy dog", "vkbs bs t suepuv", "this is a secret"),
                Arguments.of("eljuxhpwnyrdgtqkviszcfmabo", "zwx hnfx lqantp mnoeius ycgk vcnjrdb", "the five boxing wizards jump quickly")
        );
    }

}

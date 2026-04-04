package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ShortestCompletingWordTest {

    @ParameterizedTest
    @MethodSource("testData")
    void shortestCompletingWord(String licensePlate, String[] words, String expected) {
        assertEquals(expected, new ShortestCompletingWord().shortestCompletingWord(licensePlate, words));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("1s3 PSt", new String[]{"step", "steps", "stripe", "stepple"}, "steps"),
                Arguments.of("1s3 456", new String[]{"looks", "pest", "stew", "show"}, "pest")
        );
    }

}

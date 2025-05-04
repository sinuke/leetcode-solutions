package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MinimumTimeToTypeWordUsingSpecialTypewriterTest {

    @ParameterizedTest
    @MethodSource("testData")
    void minTimeToType(String word, int expected) {
        var solution = new MinimumTimeToTypeWordUsingSpecialTypewriter();
        assertEquals(expected, solution.minTimeToType(word));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("abc", 5),
                Arguments.of("bza", 7),
                Arguments.of("zjpc", 34)
        );
    }

}

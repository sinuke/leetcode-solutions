package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CircularSentenceTest {

    @ParameterizedTest
    @MethodSource("testData")
    void isCircularSentence(String sentence, boolean expected) {
        var solution = new CircularSentence();
        assertEquals(expected, solution.isCircularSentence(sentence));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("leetcode exercises sound delightful", true),
                Arguments.of("eetcode", true),
                Arguments.of("Leetcode is cool", false)
        );
    }

}

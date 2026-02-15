package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MaximumNumberOfBalloonsTest {

    @ParameterizedTest
    @MethodSource("testData")
    void maxNumberOfBalloons(String text, int expected) {
        var solution = new MaximumNumberOfBalloons();
        assertEquals(expected, solution.maxNumberOfBalloons(text));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("nlaebolko", 1),
                Arguments.of("loonbalxballpoon", 2),
                Arguments.of("leetcode", 0)
        );
    }

}

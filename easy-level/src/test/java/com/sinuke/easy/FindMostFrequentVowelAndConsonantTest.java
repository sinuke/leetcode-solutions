package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FindMostFrequentVowelAndConsonantTest {

    @ParameterizedTest
    @MethodSource("testData")
    void maxFreqSum(String s, int expected) {
        var solution = new FindMostFrequentVowelAndConsonant();
        assertEquals(expected, solution.maxFreqSum(s));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("successes", 6),
                Arguments.of("aeiaeia", 3)
        );
    }

}

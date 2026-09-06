package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MaximumRepeatingSubstringTest {

    @ParameterizedTest
    @MethodSource("testData")
    void shouldReturnMaximumKRepeatingValue(String sequence, String word, int expected) {
        var solution = new Solution();
        assertEquals(expected, solution.maxRepeating(sequence, word));
    }

    static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("ababc", "ab", 2),
                Arguments.of("ababc", "ba", 1),
                Arguments.of("ababc", "ac", 0),
                Arguments.of("aaabaaaabaaabaaaabaaaabaaaabaaaaba", "aaaba", 5)
        );
    }

}

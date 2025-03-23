package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RemoveLetterToEqualizeFrequencyTest {

    @ParameterizedTest
    @MethodSource("testData")
    void equalFrequency(String word, boolean expected) {
        var solution = new RemoveLetterToEqualizeFrequency();
        assertEquals(expected, solution.equalFrequency(word));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("abcc", true),
                Arguments.of("aazz", false),
                Arguments.of("bac", true),
                Arguments.of("abbcc", true)
        );
    }

}

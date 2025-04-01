package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DecryptStringFromAlphabetToIntegerMappingTest {

    @ParameterizedTest
    @MethodSource("testData")
    void freqAlphabets(String s, String expected) {
        var solution = new DecryptStringFromAlphabetToIntegerMapping();
        assertEquals(expected, solution.freqAlphabets(s));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("10#11#12", "jkab"),
                Arguments.of("1326#", "acz")
        );
    }

}

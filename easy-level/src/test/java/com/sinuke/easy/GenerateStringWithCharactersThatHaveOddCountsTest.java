package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GenerateStringWithCharactersThatHaveOddCountsTest {

    @ParameterizedTest
    @MethodSource("testData")
    void generateTheString(int n, String expected) {
        var solution = new GenerateStringWithCharactersThatHaveOddCounts();
        assertEquals(expected, solution.generateTheString(n));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(4, "aaab"),
                Arguments.of(2, "ab"),
                Arguments.of(7, "aaaaaaa")
        );
    }

}
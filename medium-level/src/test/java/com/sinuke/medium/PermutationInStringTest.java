package com.sinuke.medium;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PermutationInStringTest {

    @ParameterizedTest
    @MethodSource("testData")
    void checkInclusion(String s1, String s2, boolean expected) {
        var solution = new PermutationInString();
        assertEquals(expected, solution.checkInclusion(s1, s2));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("ab", "eidbaooo", true),
                Arguments.of("ab", "eidboaoo", false),
                Arguments.of("a", "ab", true)
        );
    }

}

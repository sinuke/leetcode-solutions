package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FindSpecialSubstringOfLengthKTest {

    @ParameterizedTest
    @MethodSource("testData")
    void hasSpecialSubstring(String s, int k, boolean expected) {
        var solution = new FindSpecialSubstringOfLengthK();
        assertEquals(expected, solution.hasSpecialSubstring(s, k));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("aaabaaa", 3, true),
                Arguments.of("abc", 2, false)
        );
    }

}

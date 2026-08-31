package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MakeThreeStringsEqualTest {

    @ParameterizedTest
    @MethodSource("testData")
    void findMinimumOperations(String s1, String s2, String s3, int expected) {
        var solution = new MakeThreeStringsEqual();
        assertEquals(expected, solution.findMinimumOperations(s1, s2, s3));
    }

    static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("abc", "abb", "ab", 2),
                Arguments.of("dac", "bac", "cac", -1),
                Arguments.of("abc", "abcd", "ab", 3)
        );
    }
}

package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ReverseDegreeOfStringTest {

    @ParameterizedTest
    @MethodSource("testData")
    void reverseDegree(String s, int expected) {
        var solution = new ReverseDegreeOfString();
        assertEquals(expected, solution.reverseDegree(s));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("abc", 148),
                Arguments.of("zaza", 160)
        );
    }

}

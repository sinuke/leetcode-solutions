package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CheckBalancedStringTest {

    @ParameterizedTest
    @MethodSource("testData")
    void isBalanced(String num, boolean expected) {
        var solution = new CheckBalancedString();
        assertEquals(expected, solution.isBalanced(num));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("1234", false),
                Arguments.of("24123", true)
        );
    }

}

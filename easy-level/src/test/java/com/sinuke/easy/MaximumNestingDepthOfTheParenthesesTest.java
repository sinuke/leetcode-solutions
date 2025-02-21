package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MaximumNestingDepthOfTheParenthesesTest {

    @ParameterizedTest
    @MethodSource("testData")
    void maxDepth(String s, int expected) {
        var solution = new MaximumNestingDepthOfTheParentheses();
        assertEquals(expected, solution.maxDepth(s));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("(1+(2*3)+((8)/4))+1", 3),
                Arguments.of("(1)+((2))+(((3)))", 3),
                Arguments.of("()(())((()()))", 3)
        );
    }

}

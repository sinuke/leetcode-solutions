package com.sinuke.medium;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ReverseSubstringsBetweenEachPairOfParenthesesTest {

    @ParameterizedTest
    @MethodSource("testData")
    void reverseParentheses(String s, String expected) {
        var solution = new ReverseSubstringsBetweenEachPairOfParentheses();
        assertEquals(expected, solution.reverseParentheses(s));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("(abcd)", "dcba"),
                Arguments.of("(u(love)i)", "iloveu"),
                Arguments.of("(ed(et(oc))el)", "leetcode")
        );
    }

}

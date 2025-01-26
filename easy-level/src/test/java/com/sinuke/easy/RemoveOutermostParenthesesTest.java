package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RemoveOutermostParenthesesTest {

    @ParameterizedTest
    @MethodSource("testData")
    void removeOuterParentheses(String s, String expected) {
        var remove = new RemoveOutermostParentheses();
        assertEquals(expected, remove.removeOuterParentheses(s));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("(()())(())", "()()()"),
                Arguments.of("(()())(())(()(()))", "()()()()(())"),
                Arguments.of("()()", "")
        );
    }

}

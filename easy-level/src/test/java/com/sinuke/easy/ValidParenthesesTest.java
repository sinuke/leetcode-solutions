package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ValidParenthesesTest {

    @ParameterizedTest
    @MethodSource("testData")
    void isValid(String input, boolean expected) {
        var validParentheses = new ValidParentheses();
        assertEquals(expected, validParentheses.isValid(input));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("()", true),
                Arguments.of("()[]{}", true),
                Arguments.of("(]", false),
                Arguments.of("([])", true)
        );
    }

}

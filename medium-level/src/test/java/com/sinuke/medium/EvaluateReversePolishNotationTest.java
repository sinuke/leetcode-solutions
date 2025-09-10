package com.sinuke.medium;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EvaluateReversePolishNotationTest {

    @ParameterizedTest
    @MethodSource("testData")
    void evalRPN(String[] tokens, int expected) {
        var solution = new EvaluateReversePolishNotation();
        assertEquals(expected, solution.evalRPN(tokens));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new String[] {"2","1","+","3","*"}, 9),
                Arguments.of(new String[] {"4","13","5","/","+"}, 6),
                Arguments.of(new String[] {"10","6","9","3","+","-11","*","/","*","17","+","5","+"}, 22)
        );
    }

}

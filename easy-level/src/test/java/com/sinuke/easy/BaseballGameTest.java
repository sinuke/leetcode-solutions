package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BaseballGameTest {

    @ParameterizedTest
    @MethodSource("testData")
    void calPoints(String[] operations, int expected) {
        var solution = new BaseballGame();
        assertEquals(expected, solution.calPoints(operations));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new String[] {"5","2","C","D","+"}, 30),
                Arguments.of(new String[] {"5","-2","4","C","D","9","+","+"}, 27),
                Arguments.of(new String[] {"1","C"}, 0)
        );
    }

}

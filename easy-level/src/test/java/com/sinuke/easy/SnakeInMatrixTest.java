package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SnakeInMatrixTest {

    @ParameterizedTest
    @MethodSource("testData")
    void finalPositionOfSnake(int n, List<String> commands, int expected) {
        var solution = new SnakeInMatrix();
        assertEquals(expected, solution.finalPositionOfSnake(n, commands));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(2, List.of("RIGHT","DOWN"), 3),
                Arguments.of(3, List.of("DOWN","RIGHT","UP"), 1)
        );
    }

}

package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LuckyNumbersInMatrixTest {

    @ParameterizedTest
    @MethodSource("testData")
    void luckyNumbers(int[][] matrix, List<Integer> expected) {
        var solution = new LuckyNumbersInMatrix();
        assertEquals(expected, solution.luckyNumbers(matrix));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[][] {{3,7,8},{9,11,13},{15,16,17}}, List.of(15)),
                Arguments.of(new int[][] {{1,10,4,2},{9,3,8,7},{15,16,17,12}}, List.of(12)),
                Arguments.of(new int[][] {{7,8},{1,2}}, List.of(7))
        );
    }

}

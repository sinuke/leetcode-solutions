package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AvailableCapturesForRookTest {

    @ParameterizedTest
    @MethodSource("testData")
    void numRookCaptures(char[][] board, int expected) {
        var solution = new AvailableCapturesForRook();
        assertEquals(expected, solution.numRookCaptures(board));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new char[][] {{'.','.','.','.','.','.','.','.'},{'.','.','.','p','.','.','.','.'},{'.','.','.','R','.','.','.','p'},{'.','.','.','.','.','.','.','.'},{'.','.','.','.','.','.','.','.'},{'.','.','.','p','.','.','.','.'},{'.','.','.','.','.','.','.','.'},{'.','.','.','.','.','.','.','.'}}, 3),
                Arguments.of(new char[][] {{'.','.','.','.','.','.','.','.'},{'.','p','p','p','p','p','.','.'},{'.','p','p','B','p','p','.','.'},{'.','p','B','R','B','p','.','.'},{'.','p','p','B','p','p','.','.'},{'.','p','p','p','p','p','.','.'},{'.','.','.','.','.','.','.','.'},{'.','.','.','.','.','.','.','.'}}, 0),
                Arguments.of(new char[][] {{'.','.','.','.','.','.','.','.'},{'.','.','.','p','.','.','.','.'},{'.','.','.','p','.','.','.','.'},{'p','p','.','R','.','p','B','.'},{'.','.','.','.','.','.','.','.'},{'.','.','.','B','.','.','.','.'},{'.','.','.','p','.','.','.','.'},{'.','.','.','.','.','.','.','.'}}, 3)
        );
    }

}

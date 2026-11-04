package com.sinuke.medium;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class WordSearchTest {

    @ParameterizedTest
    @MethodSource("testData")
    void exist(char[][] board, String word, boolean expected) {
        var solution = new WordSearch();
        assertEquals(expected, solution.exist(board, word));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}}, "ABCCED", true),
                Arguments.of(new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}}, "SEE", true),
                Arguments.of(new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}}, "ABCB", false),
                Arguments.of(new char[][]{{'A', 'A', 'A', 'A', 'A', 'A'}, {'A', 'A', 'A', 'B', 'A', 'A'}, {'A', 'A', 'A', 'A', 'A', 'A'}, {'A', 'A', 'A', 'A', 'A', 'A'}, {'A', 'A', 'A', 'A', 'A', 'A'}, {'A', 'A', 'A', 'A', 'A', 'A'}}, "AB", true),
                Arguments.of(new char[][]{{'A','B','C','E'},{'S','F','E','S'},{'A','D','E','E'}}, "ABCESEEEFS", true)
        );
    }

}

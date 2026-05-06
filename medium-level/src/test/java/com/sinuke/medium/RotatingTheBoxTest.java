package com.sinuke.medium;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class RotatingTheBoxTest {

    @ParameterizedTest
    @MethodSource("testData")
    void rotateTheBox(char[][] box, char[][] expected) {
        assertArrayEquals(expected, new RotatingTheBox().rotateTheBox(box));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(
                        new char[][]{{'#', '.', '#'}},
                        new char[][]{{'.'},{'#'},{'#'}}
                ),
                Arguments.of(
                        new char[][]{{'#', '.', '*', '.'}, {'#', '#', '*', '.'}},
                        new char[][]{{'#', '.'}, {'#', '#'}, {'*', '*'}, {'.', '.'}}
                ),
                Arguments.of(
                        new char[][]{{'#', '#', '*', '.', '*', '.'}, {'#', '#', '#', '*', '.', '.'}, {'#', '#', '#', '.', '#', '.'}},
                        new char[][]{{'.', '#', '#'}, {'.', '#', '#'}, {'#', '#', '*'}, {'#', '*', '.'}, {'#', '.', '*'}, {'#', '.', '.'}}
                )
        );
    }

}

package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class DefuseTheBombTest {

    @ParameterizedTest
    @MethodSource("testData")
    void decrypt(int[] code, int k, int[] expected) {
        var solution = new DefuseTheBomb();
        assertArrayEquals(expected, solution.decrypt(code, k));
        assertArrayEquals(expected, solution.decrypt2(code, k));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[] {5,7,1,4}, 3, new int[] {12,10,16,13}),
                Arguments.of(new int[] {1,2,3,4}, 0, new int[] {0,0,0,0}),
                Arguments.of(new int[] {2,4,9,3}, -2, new int[] {12,5,6,13})
        );
    }

}

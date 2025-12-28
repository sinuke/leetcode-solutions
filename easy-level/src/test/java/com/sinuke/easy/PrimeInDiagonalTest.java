package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PrimeInDiagonalTest {

    @ParameterizedTest
    @MethodSource("testData")
    void diagonalPrime(int[][] nums, int expected) {
        var solution = new PrimeInDiagonal();
        assertEquals(expected, solution.diagonalPrime(nums));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[][] {{1,2,3},{5,6,7},{9,10,11}}, 11),
                Arguments.of(new int[][] {{1,2,3},{5,17,7},{9,11,10}}, 17),
                Arguments.of(new int[][] {{1,1},{1,1}}, 0)
        );
    }

}

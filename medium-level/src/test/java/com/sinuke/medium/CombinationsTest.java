package com.sinuke.medium;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CombinationsTest {

    @ParameterizedTest
    @MethodSource("testData")
    void combine(int n, int k, List<List<Integer>> expected) {
        var solution = new Combinations();
        assertEquals(expected, solution.combine(n, k));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(4, 2, List.of(List.of(1,2), List.of(1,3), List.of(1,4), List.of(2,3), List.of(2,4), List.of(3,4))),
                Arguments.of(1, 1, List.of(List.of(1)))
        );
    }

}

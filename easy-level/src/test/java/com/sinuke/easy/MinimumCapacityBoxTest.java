package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MinimumCapacityBoxTest {

    @ParameterizedTest
    @MethodSource("testData")
    void minimumIndex(int[] capacity, int itemSize, int expected) {
        var solution = new MinimumCapacityBox();
        assertEquals(expected, solution.minimumIndex(capacity, itemSize));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[] {1,5,3,7}, 3, 2),
                Arguments.of(new int[] {3,5,4,3}, 2, 0),
                Arguments.of(new int[] {4}, 5, -1)
        );
    }

}

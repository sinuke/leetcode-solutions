package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RangeAdditionIITest {

    @ParameterizedTest
    @MethodSource("testData")
    void maxCount(int m, int n, int[][] ops, int expected) {
        assertEquals(expected, new RangeAdditionII().maxCount(m, n, ops));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(3, 3, new int[][]{{2, 2}, {3, 3}}, 4),
                Arguments.of(3, 3, new int[][]{{2,2},{3,3},{3,3},{3,3},{2,2},{3,3},{3,3},{3,3},{2,2},{3,3},{3,3},{3,3}}, 4),
                Arguments.of(3, 3, new int[][]{}, 9)
        );
    }

}

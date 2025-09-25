package com.sinuke.medium;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TriangleTest {

    @ParameterizedTest
    @MethodSource("testData")
    void minimumTotal(List<List<Integer>> triangle, int expected) {
        var solution = new Triangle();
        assertEquals(expected, solution.minimumTotal(triangle));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(Arrays.asList(Arrays.asList(2), Arrays.asList(3,4), Arrays.asList(6,5,7), Arrays.asList(4,1,8,3)), 11),
                Arguments.of(Arrays.asList(Arrays.asList(-10)), -10)
        );
    }

}

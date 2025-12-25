package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MaximumPopulationYearTest {

    @ParameterizedTest
    @MethodSource("testData")
    void maximumPopulation(int[][] logs, int expected) {
        var solution = new MaximumPopulationYear();
        assertEquals(expected, solution.maximumPopulation(logs));
        assertEquals(expected, solution.maximumPopulation2(logs));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[][] {{1993,1999},{2000,2010}}, 1993),
                Arguments.of(new int[][] {{1950,1961},{1960,1971},{1970,1981}}, 1960),
                Arguments.of(new int[][] {{1960,2000},{1980,1998}}, 1980)
        );
    }

}

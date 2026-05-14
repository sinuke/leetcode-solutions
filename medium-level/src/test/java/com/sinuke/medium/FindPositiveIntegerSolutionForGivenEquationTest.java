package com.sinuke.medium;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FindPositiveIntegerSolutionForGivenEquationTest {

    @ParameterizedTest
    @MethodSource("testData")
    void findSolution(FindPositiveIntegerSolutionForGivenEquation.CustomFunction customfunction, int z, List<List<Integer>> expected) {
        assertEquals(expected, new FindPositiveIntegerSolutionForGivenEquation().findSolution(customfunction, z));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(
                        (FindPositiveIntegerSolutionForGivenEquation.CustomFunction) (x, y) -> x + y, 5,
                        List.of(List.of(1, 4), List.of(2, 3), List.of(3, 2), List.of(4, 1))
                ),
                Arguments.of(
                        (FindPositiveIntegerSolutionForGivenEquation.CustomFunction) (x, y) -> x * y, 5,
                        List.of(List.of(1, 5), List.of(5, 1))
                )
        );
    }

}

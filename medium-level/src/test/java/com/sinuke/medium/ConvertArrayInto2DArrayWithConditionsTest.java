package com.sinuke.medium;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ConvertArrayInto2DArrayWithConditionsTest {

    @ParameterizedTest
    @MethodSource("testData")
    void findMatrix(int[] nums, List<List<Integer>> expected) {
        var solution = new ConvertArrayInto2DArrayWithConditions();
        assertEquals(expected, solution.findMatrix(nums));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[] {1,3,4,1,2,3,1}, List.of(List.of(1,3,4,2), List.of(1,3), List.of(1))),
                Arguments.of(new int[] {1,2,3,4}, List.of(List.of(1,2,3,4)))
        );
    }

}

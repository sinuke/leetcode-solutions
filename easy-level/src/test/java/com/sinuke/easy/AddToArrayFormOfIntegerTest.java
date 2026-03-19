package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AddToArrayFormOfIntegerTest {

    @ParameterizedTest
    @MethodSource("testData")
    void addToArrayForm(int[] num, int k, List<Integer> expected) {
        var solution = new AddToArrayFormOfInteger();
        assertEquals(expected, solution.addToArrayForm(num, k));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[] {1,2,0,0}, 34, List.of(1,2,3,4)),
                Arguments.of(new int[] {2,7,4}, 181, List.of(4,5,5)),
                Arguments.of(new int[] {2,1,5}, 806, List.of(1,0,2,1))
        );
    }

}

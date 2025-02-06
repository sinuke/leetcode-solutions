package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TupleWithSameProductTest {

    @ParameterizedTest
    @MethodSource("testData")
    void tupleSameProduct(int[] nums, int expected) {
        var solution = new TupleWithSameProduct();
        assertEquals(expected, solution.tupleSameProduct(nums));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[] {2,3,4,6}, 8),
                Arguments.of(new int[] {1,2,4,5,10}, 16),
                Arguments.of(new int[] {2,3,4,6,8,12}, 40)
        );
    }

}

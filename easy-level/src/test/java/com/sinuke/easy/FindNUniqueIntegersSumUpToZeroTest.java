package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FindNUniqueIntegersSumUpToZeroTest {

    @ParameterizedTest
    @MethodSource("testData")
    void sumZero(int n, int[] expected) {
        var solution = new FindNUniqueIntegersSumUpToZero();
        int[] actual = solution.sumZero(n);

        assertEquals(expected.length, actual.length);
        assertEquals(Arrays.stream(expected).sum(), Arrays.stream(actual).sum());
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(5, new int[] {-7,-1,1,3,4}),
                Arguments.of(3, new int[] {-1,0,1}),
                Arguments.of(1, new int[] {0})
        );
    }

}

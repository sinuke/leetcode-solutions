package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SortArrayByParityTest {

    @ParameterizedTest
    @MethodSource("testData")
    void sortArrayByParity(int[] nums, int[] expected) {
        var solution = new SortArrayByParity();
        assertArrayEquals(expected, solution.sortArrayByParity(nums));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[] {3,1,2,4}, new int[] {2,4,1,3}),
                Arguments.of(new int[] {0}, new int[] {0})
        );
    }

}

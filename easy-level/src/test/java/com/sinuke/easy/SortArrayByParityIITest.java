package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SortArrayByParityIITest {

    @ParameterizedTest
    @MethodSource("testData")
    void sortArrayByParityII(int[] nums, int[] expected) {
        var solution = new SortArrayByParityII();
        assertArrayEquals(expected, solution.sortArrayByParityII(nums));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[] {4,2,5,7}, new int[] {4,5,2,7}),
                Arguments.of(new int[] {2,3}, new int[] {2,3})
        );
    }

}

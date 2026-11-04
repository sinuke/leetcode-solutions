package com.sinuke.medium;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SingleNumberIIITest {

    @ParameterizedTest
    @MethodSource("testData")
    void singleNumber(int[] nums, int[] expected) {
        var solution = new SingleNumberIII();
        var actual = solution.singleNumber(nums);

        Arrays.sort(expected);
        Arrays.sort(actual);

        assertArrayEquals(expected, actual);
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[] {1,2,1,3,2,5}, new int[] {3,5}),
                Arguments.of(new int[] {-1,0}, new int[] {-1,0}),
                Arguments.of(new int[] {0,1}, new int[] {1,0})
        );
    }

}

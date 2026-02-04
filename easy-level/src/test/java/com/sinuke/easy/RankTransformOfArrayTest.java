package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class RankTransformOfArrayTest {

    @ParameterizedTest
    @MethodSource("testData")
    void arrayRankTransform(int[] arr, int[] expected) {
        var solution = new RankTransformOfArray();
        assertArrayEquals(expected, solution.arrayRankTransform(arr));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[] {40,10,20,30}, new int[] {4,1,2,3}),
                Arguments.of(new int[] {100,100,100}, new int[] {1,1,1}),
                Arguments.of(new int[] {37,12,28,9,100,56,80,5,12}, new int[] {5,3,4,2,8,6,7,1,3})
        );
    }

}

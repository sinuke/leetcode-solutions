package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FindIndicesOfStableMountainsTest {

    @ParameterizedTest
    @MethodSource("testData")
    void stableMountains(int[] heights, int threshold, List<Integer> expected) {
        var finder = new FindIndicesOfStableMountains();
        assertEquals(expected, finder.stableMountains(heights, threshold));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[] {1,2,3,4,5}, 2, List.of(3, 4)),
                Arguments.of(new int[] {10,1,10,1,10}, 3, List.of(1,3)),
                Arguments.of(new int[] {10,1,10,1,10}, 10, List.of())
        );
    }

}

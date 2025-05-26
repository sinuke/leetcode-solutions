package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FindLuckyIntegerInArrayTest {

    @ParameterizedTest
    @MethodSource("testData")
    void findLucky(int[] arr, int expected) {
        var solution = new FindLuckyIntegerInArray();
        assertEquals(expected, solution.findLucky(arr));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[] {2,2,3,4}, 2),
                Arguments.of(new int[] {1,2,2,3,3,3}, 3),
                Arguments.of(new int[] {2,2,2,3,3}, -1)
        );
    }

}

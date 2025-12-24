package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AppleRedistributionIntoBoxesTest {

    @ParameterizedTest
    @MethodSource("testData")
    void minimumBoxes(int[] apple, int[] capacity, int expected) {
        var solution = new AppleRedistributionIntoBoxes();
        assertEquals(expected, solution.minimumBoxes(apple, capacity));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[] {1,3,2}, new int[] {4,3,1,5,2}, 2),
                Arguments.of(new int[] {5,5,5}, new int[] {2,4,2,7}, 4),
                Arguments.of(new int[] {9,8,8,2,3,1,6}, new int[] {10,1,4,10,8,5}, 5)
        );
    }

}

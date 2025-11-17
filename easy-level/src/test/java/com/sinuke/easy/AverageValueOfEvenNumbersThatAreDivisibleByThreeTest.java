package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AverageValueOfEvenNumbersThatAreDivisibleByThreeTest {

    @ParameterizedTest
    @MethodSource("testData")
    void averageValue(int[] nums, int expected) {
        var solution = new AverageValueOfEvenNumbersThatAreDivisibleByThree();
        assertEquals(expected, solution.averageValue(nums));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[] {1,3,6,10,12,15}, 9),
                Arguments.of(new int[] {1,2,4,7,10}, 0)
        );
    }

}

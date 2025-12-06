package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SignOfTheProductOfArrayTest {

    @ParameterizedTest
    @MethodSource("testData")
    void arraySign(int[] nums, int expected) {
        var solution = new SignOfTheProductOfArray();
        assertEquals(expected, solution.arraySign(nums));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[] {-1,-2,-3,-4,3,2,1}, 1),
                Arguments.of(new int[] {1,5,0,2,-3}, 0),
                Arguments.of(new int[] {-1,1,-1,1,-1}, -1)
        );
    }

}

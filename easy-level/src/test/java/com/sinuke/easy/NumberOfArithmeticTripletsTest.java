package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NumberOfArithmeticTripletsTest {

    @ParameterizedTest
    @MethodSource("testData")
    void arithmeticTriplets(int[] nums, int diff, int expected) {
        var numberOfArithmeticTriplets = new NumberOfArithmeticTriplets();
        assertEquals(expected, numberOfArithmeticTriplets.arithmeticTriplets(nums, diff));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[] {0,1,4,6,7,10}, 3, 2),
                Arguments.of(new int[] {4,5,6,7,8,9}, 2, 2)
        );
    }

}

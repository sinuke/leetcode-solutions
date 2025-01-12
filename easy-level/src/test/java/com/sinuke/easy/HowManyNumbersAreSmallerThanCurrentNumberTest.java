package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class HowManyNumbersAreSmallerThanCurrentNumberTest {

    @ParameterizedTest
    @MethodSource("testData")
    void smallerNumbersThanCurrent(int[] nums, int[] expected) {
        var smallerNumbersThanCurrentNumber = new HowManyNumbersAreSmallerThanCurrentNumber();
        assertArrayEquals(expected, smallerNumbersThanCurrentNumber.smallerNumbersThanCurrent(nums));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[] {8,1,2,2,3}, new int[] {4,0,1,1,3}),
                Arguments.of(new int[] {6,5,4,8}, new int[] {2,1,0,3}),
                Arguments.of(new int[] {7,7,7,7}, new int[] {0,0,0,0})
        );
    }

}

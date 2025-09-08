package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class ConvertIntegerToTheSumOfTwoNoZeroIntegersTest {

    @ParameterizedTest
    @MethodSource("testData")
    void getNoZeroIntegers(int n, int[] expected) {
        var solution = new ConvertIntegerToTheSumOfTwoNoZeroIntegers();
        assertArrayEquals(expected, solution.getNoZeroIntegers(n));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(2, new int[] {1,1}),
                Arguments.of(11, new int[] {2,9}),
                Arguments.of(1010, new int[] {11,999})
        );
    }

}

package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class Finding3DigitEvenNumbersTest {

    @ParameterizedTest
    @MethodSource("testData")
    void findEvenNumbers(int[] digits, int[] expected) {
        var solution = new Finding3DigitEvenNumbers();
        assertArrayEquals(expected, solution.findEvenNumbers(digits));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[] {2,1,3,0}, new int[] {102,120,130,132,210,230,302,310,312,320}),
                Arguments.of(new int[] {2,2,8,8,2}, new int[] {222,228,282,288,822,828,882}),
                Arguments.of(new int[] {3,7,5}, new int[] {}),
                Arguments.of(new int[] {3,3,8,4}, new int[] {334,338,348,384,438,834})
        );
    }

}

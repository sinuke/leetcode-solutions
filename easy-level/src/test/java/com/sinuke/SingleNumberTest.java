package com.sinuke;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SingleNumberTest {

    @ParameterizedTest
    @MethodSource("testData")
    void singleNumber(int[] input, int expected) {
        var singleNumber = new SingleNumber();

        assertEquals(expected, singleNumber.singleNumber(input));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[] {2, 2, 1}, 1),
                Arguments.of(new int[] {4, 1, 2, 1, 2}, 4),
                Arguments.of(new int[] {1}, 1),
                Arguments.of(new int[] {1, 2, 1, 2, 3}, 3),
                Arguments.of(new int[] {1, 2, 3, 4, 5, 1, 2, 3, 4}, 5)
        );
    }

}

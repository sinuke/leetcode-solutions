package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SumOfCompatibleNumbersInRangeITest {

    @ParameterizedTest
    @MethodSource("testData")
    void sumOfGoodIntegers(int n, int k, int expected) {
        assertEquals(expected, new SumOfCompatibleNumbersInRangeI().sumOfGoodIntegers(n, k));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(2, 3, 10),
                Arguments.of(5, 1, 0)
        );
    }

}

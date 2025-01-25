package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CountTheDigitsThatDivideNumberTest {

    @ParameterizedTest
    @MethodSource("testData")
    void countDigits(int num, int expected) {
        var counter = new CountTheDigitsThatDivideNumber();
        assertEquals(expected, counter.countDigits(num));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(7, 1),
                Arguments.of(121, 2),
                Arguments.of(1248, 4)
        );
    }

}

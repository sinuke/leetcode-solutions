package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Largest3SameDigitNumberInStringTest {

    @ParameterizedTest
    @MethodSource("testData")
    void largestGoodInteger(String num, String expected) {
        var solution = new Largest3SameDigitNumberInString();
        assertEquals(expected, solution.largestGoodInteger(num));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("6777133339", "777"),
                Arguments.of("2300019", "000"),
                Arguments.of("42352338", "")
        );
    }

}

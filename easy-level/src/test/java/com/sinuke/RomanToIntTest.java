package com.sinuke;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RomanToIntTest {

    @ParameterizedTest
    @MethodSource("testData")
    void romanToInt(String input, int expected) {
        var romanToInt = new RomanToInt();
        assertEquals(expected, romanToInt.romanToInt(input));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("III", 3),
                Arguments.of("LVIII", 58),
                Arguments.of("MCMXCIV", 1994)
        );
    }

}

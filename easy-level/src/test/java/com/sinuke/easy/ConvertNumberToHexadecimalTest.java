package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ConvertNumberToHexadecimalTest {

    @ParameterizedTest
    @MethodSource("testData")
    void toHex(int num, String expected) {
        var solution = new ConvertNumberToHexadecimal();
        assertEquals(expected, solution.toHex(num));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(26, "1a"),
                Arguments.of(-1, "ffffffff"),
                Arguments.of(43981, "abcd"),
                Arguments.of(0, "0")
        );
    }

}

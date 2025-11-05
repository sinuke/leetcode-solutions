package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HexadecimalAndHexatrigesimalConversionTest {

    @ParameterizedTest
    @MethodSource("testData")
    void concatHex36(int n, String expected) {
        var solution = new HexadecimalAndHexatrigesimalConversion();
        assertEquals(expected, solution.concatHex36(n));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(13, "A91P1"),
                Arguments.of(36, "5101000")
        );
    }

}

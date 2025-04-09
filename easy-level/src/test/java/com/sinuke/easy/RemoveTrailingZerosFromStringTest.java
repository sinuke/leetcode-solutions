package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RemoveTrailingZerosFromStringTest {

    @ParameterizedTest
    @MethodSource("testData")
    void removeTrailingZeros(String num, String expected) {
        var solution = new RemoveTrailingZerosFromString();
        assertEquals(expected, solution.removeTrailingZeros(num));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("51230100", "512301"),
                Arguments.of("123", "123")
        );
    }

}

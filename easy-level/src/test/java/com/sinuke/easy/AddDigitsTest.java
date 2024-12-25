package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AddDigitsTest {

    @ParameterizedTest
    @MethodSource("testData")
    void addDigits(int num, int expected) {
        var addDigits = new AddDigits();
        assertEquals(expected, addDigits.addDigits(num));
        assertEquals(expected, addDigits.addDigitsRecursive(num));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(38, 2),
                Arguments.of(0, 0)
        );
    }

}

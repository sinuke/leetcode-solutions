package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ComplementOfBase10IntegerTest {

    @ParameterizedTest
    @MethodSource("testData")
    void bitwiseComplement(int n, int expected) {
        var complementOfBase10Integer = new ComplementOfBase10Integer();
        assertEquals(expected, complementOfBase10Integer.bitwiseComplement(n));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(5, 2),
                Arguments.of(7, 0),
                Arguments.of(10, 5)
        );
    }

}
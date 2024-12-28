package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NumberComplementTest {

    @ParameterizedTest
    @MethodSource("testData")
    void findComplement(int num, int expected) {
        var finder = new NumberComplement();
        assertEquals(expected, finder.findComplement(num));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(5, 2),
                Arguments.of(1, 0)
        );
    }

}

package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Base7Test {

    @ParameterizedTest
    @MethodSource("testData")
    void convertToBase7(int num, String expected) {
        var solution = new Base7();
        assertEquals(expected, solution.convertToBase7(num));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(100, "202"),
                Arguments.of(-7, "-10")
        );
    }

}

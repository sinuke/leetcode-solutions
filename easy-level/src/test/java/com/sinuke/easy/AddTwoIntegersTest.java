package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AddTwoIntegersTest {

    @ParameterizedTest
    @MethodSource("testData")
    void sum(int num1, int num2, int expected) {
        var addTwoIntegers = new AddTwoIntegers();
        assertEquals(expected, addTwoIntegers.sum(num1, num2));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(12, 5, 17),
                Arguments.of(-10, 4, -6)
        );
    }

}

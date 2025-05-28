package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FindTheKeyOfTheNumbersTest {

    @ParameterizedTest
    @MethodSource("testData")
    void generateKey(int num1, int num2, int num3, int expected) {
        var solution = new FindTheKeyOfTheNumbers();
        assertEquals(expected, solution.generateKey(num1, num2, num3));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(1, 10, 1000, 0),
                Arguments.of(987, 879, 798, 777)
        );
    }

}

package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CountSymmetricIntegersTest {

    @ParameterizedTest
    @MethodSource("testData")
    void countSymmetricIntegers(int low, int high, int expected) {
        var solution = new CountSymmetricIntegers();
        assertEquals(expected, solution.countSymmetricIntegers(low, high));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(1, 100, 9),
                Arguments.of(1200, 1230, 4)
        );
    }

}

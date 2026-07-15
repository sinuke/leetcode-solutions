package com.sinuke.medium;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SequentialDigitsTest {

    @ParameterizedTest
    @MethodSource("testData")
    void sequentialDigits(int low, int high, List<Integer> expected) {
        assertEquals(expected, new SequentialDigits().sequentialDigits(low, high));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(100, 300, List.of(123, 234)),
                Arguments.of(1000, 13000, List.of(1234, 2345, 3456, 4567, 5678, 6789, 12345))
        );
    }

}

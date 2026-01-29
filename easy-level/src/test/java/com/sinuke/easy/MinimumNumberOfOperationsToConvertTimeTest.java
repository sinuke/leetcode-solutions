package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MinimumNumberOfOperationsToConvertTimeTest {

    @ParameterizedTest
    @MethodSource("testData")
    void convertTime(String current, String correct, int expected) {
        var solution = new MinimumNumberOfOperationsToConvertTime();
        assertEquals(expected, solution.convertTime(current, correct));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("02:30", "04:35", 3),
                Arguments.of("11:00", "11:01", 1)
        );
    }

}

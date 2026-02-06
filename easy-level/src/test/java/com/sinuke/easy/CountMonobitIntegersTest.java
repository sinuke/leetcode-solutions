package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CountMonobitIntegersTest {

    @ParameterizedTest
    @MethodSource("testData")
    void countMonobit(int n, int expected) {
        var solution = new CountMonobitIntegers();
        assertEquals(expected, solution.countMonobit(n));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(1, 2),
                Arguments.of(4, 3)
        );
    }

}

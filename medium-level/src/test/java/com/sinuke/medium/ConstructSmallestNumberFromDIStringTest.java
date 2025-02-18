package com.sinuke.medium;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ConstructSmallestNumberFromDIStringTest {

    @ParameterizedTest
    @MethodSource("testData")
    void smallestNumber(String pattern, String expected) {
        var solution = new ConstructSmallestNumberFromDIString();
        assertEquals(expected, solution.smallestNumber(pattern));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("IIIDIDDD", "123549876"),
                Arguments.of("DDD", "4321")
        );
    }

}

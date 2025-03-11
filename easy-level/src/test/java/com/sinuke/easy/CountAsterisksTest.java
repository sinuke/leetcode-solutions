package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CountAsterisksTest {

    @ParameterizedTest
    @MethodSource("testData")
    void countAsterisks(String s, int expected) {
        var solution = new CountAsterisks();
        assertEquals(expected, solution.countAsterisks(s));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("l|*e*et|c**o|*de|", 2),
                Arguments.of("iamprogrammer", 0),
                Arguments.of("yo|uar|e**|b|e***au|tifu|l", 5)
        );
    }

}

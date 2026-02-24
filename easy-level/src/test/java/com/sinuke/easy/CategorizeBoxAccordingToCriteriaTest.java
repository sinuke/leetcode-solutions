package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CategorizeBoxAccordingToCriteriaTest {

    @ParameterizedTest
    @MethodSource("testData")
    void categorizeBox(int length, int width, int height, int mass, String expected) {
        var solution = new CategorizeBoxAccordingToCriteria();
        assertEquals(expected, solution.categorizeBox(length, width, height, mass));
        assertEquals(expected, solution.categorizeBox2(length, width, height, mass));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(1000, 35, 700, 300, "Heavy"),
                Arguments.of(200, 50, 800, 50, "Neither")
        );
    }

}

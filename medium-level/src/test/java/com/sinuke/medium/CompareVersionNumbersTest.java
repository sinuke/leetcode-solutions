package com.sinuke.medium;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CompareVersionNumbersTest {

    @ParameterizedTest
    @MethodSource("testData")
    void compareVersion(String version1, String version2, int expected) {
        var solution = new CompareVersionNumbers();
        assertEquals(expected, solution.compareVersion(version1, version2));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("1.2", "1.10", -1),
                Arguments.of("1.0", "1.0.0.0", 0),
                Arguments.of("1.01", "1.001", 0)
        );
    }

}

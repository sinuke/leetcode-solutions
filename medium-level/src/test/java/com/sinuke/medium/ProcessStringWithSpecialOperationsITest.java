package com.sinuke.medium;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ProcessStringWithSpecialOperationsITest {

    @ParameterizedTest
    @MethodSource("testData")
    void processStr(String s, String expected) {
        var solution = new ProcessStringWithSpecialOperationsI();
        assertEquals(expected, solution.processStr(s));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("a#b%*", "ba"),
                Arguments.of("z*#", "")
        );
    }

}

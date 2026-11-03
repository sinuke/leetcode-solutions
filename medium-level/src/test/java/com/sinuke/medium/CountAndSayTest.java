package com.sinuke.medium;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CountAndSayTest {

    @ParameterizedTest
    @MethodSource("testData")
    void countAndSay(int n, String expected) {
        var solution = new CountAndSay();
        assertEquals(expected, solution.countAndSay(n));
        assertEquals(expected, solution.countAndSay2(n));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(4, "1211"),
                Arguments.of(1, "1")
        );
    }

}

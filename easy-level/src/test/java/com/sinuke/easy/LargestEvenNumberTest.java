package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LargestEvenNumberTest {

    @ParameterizedTest
    @MethodSource("testData")
    void largestEven(String s, String expected) {
        var solution = new LargestEvenNumber();
        assertEquals(expected, solution.largestEven(s));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("1112", "1112"),
                Arguments.of("221", "22"),
                Arguments.of("1", "")
        );
    }

}

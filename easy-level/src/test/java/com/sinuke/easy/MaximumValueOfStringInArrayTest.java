package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MaximumValueOfStringInArrayTest {

    @ParameterizedTest
    @MethodSource("testData")
    void maximumValue(String[] strs, int expected) {
        var solution = new MaximumValueOfStringInArray();
        assertEquals(expected, solution.maximumValue(strs));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new String[] {"alic3","bob","3","4","00000"}, 5),
                Arguments.of(new String[] {"1","01","001","0001"}, 1)
        );
    }

}

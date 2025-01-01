package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class ConcatenationOfArrayTest {

    @ParameterizedTest
    @MethodSource("testData")
    void getConcatenation(int[] nums, int[] expected) {
        var concatenation = new ConcatenationOfArray();
        assertArrayEquals(expected, concatenation.getConcatenation(nums));
        assertArrayEquals(expected, concatenation.getConcatenation2(nums));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[] {1,2,1}, new int[] {1,2,1,1,2,1}),
                Arguments.of(new int[] {1,3,2,1}, new int[] {1,3,2,1,1,3,2,1})
        );
    }

}

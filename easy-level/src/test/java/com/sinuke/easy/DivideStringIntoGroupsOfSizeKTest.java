package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class DivideStringIntoGroupsOfSizeKTest {

    @ParameterizedTest
    @MethodSource("testData")
    void divideString(String s, int k, char fill, String[] expected) {
        var solution = new DivideStringIntoGroupsOfSizeK();
        assertArrayEquals(expected, solution.divideString(s, k, fill));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("abcdefghi", 3, 'x', new String[] {"abc","def","ghi"}),
                Arguments.of("abcdefghij", 3, 'x', new String[] {"abc","def","ghi","jxx"})
        );
    }

}

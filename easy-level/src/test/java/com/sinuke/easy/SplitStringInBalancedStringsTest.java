package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SplitStringInBalancedStringsTest {

    @ParameterizedTest
    @MethodSource("testData")
    void balancedStringSplit(String s, int expected) {
        var splitter = new SplitStringInBalancedStrings();
        assertEquals(expected, splitter.balancedStringSplit(s));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("RLRRLLRLRL", 4),
                Arguments.of("RLRRRLLRLL", 2),
                Arguments.of("LLLLRRRR", 1)
        );
    }

}

package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ShuffleStringTest {

    @ParameterizedTest
    @MethodSource("testData")
    void restoreString(String s, int[] indices, String expected) {
        var shuffle = new ShuffleString();
        assertEquals(expected, shuffle.restoreString(s, indices));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("codeleet", new int[] {4,5,6,7,0,2,1,3}, "leetcode"),
                Arguments.of("abc", new int[] {0,1,2}, "abc")
        );
    }

}

package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class DiStringMatchTest {

    @ParameterizedTest
    @MethodSource("testData")
    void diStringMatch(String s, int[] expected) {
        assertArrayEquals(expected, new DiStringMatch().diStringMatch(s));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("IDID", new int[] {0, 4, 1, 3, 2}),
                Arguments.of("III", new int[] {0, 1, 2, 3}),
                Arguments.of("DDI", new int[] {3, 2, 0, 1})
        );
    }

}

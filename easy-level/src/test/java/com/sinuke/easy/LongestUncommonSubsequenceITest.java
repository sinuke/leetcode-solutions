package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LongestUncommonSubsequenceITest {

    @ParameterizedTest
    @MethodSource("testData")
    void findLUSlength(String a, String b, int expected) {
        var solution = new LongestUncommonSubsequenceI();
        assertEquals(expected, solution.findLUSlength(a, b));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("aba", "cdc", 3),
                Arguments.of("aaa", "bbb", 3),
                Arguments.of("aaa", "aaa", -1)
        );
    }

}

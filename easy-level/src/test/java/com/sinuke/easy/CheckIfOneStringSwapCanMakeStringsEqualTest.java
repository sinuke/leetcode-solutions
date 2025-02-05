package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CheckIfOneStringSwapCanMakeStringsEqualTest {

    @ParameterizedTest
    @MethodSource("testData")
    void areAlmostEqual(String s1, String s2, boolean expected) {
        var checker = new CheckIfOneStringSwapCanMakeStringsEqual();
        assertEquals(expected, checker.areAlmostEqual(s1, s2));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("bank", "kanb", true),
                Arguments.of("attack", "defend", false),
                Arguments.of("kelb", "kelb", true),
                Arguments.of("caa", "aaz", false)
        );
    }

}

package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LongPressedNameTest {

    @ParameterizedTest
    @MethodSource("testData")
    void isLongPressedName(String name, String typed, boolean expected) {
        assertEquals(expected, new LongPressedName().isLongPressedName(name, typed));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("alex", "aaleex", true),
                Arguments.of("saeed", "ssaaedd", false),
                Arguments.of("a", "b", false),
                Arguments.of("alex", "aaleexa", false),
                Arguments.of("pyplrz", "ppyypllr", false)
        );
    }

}

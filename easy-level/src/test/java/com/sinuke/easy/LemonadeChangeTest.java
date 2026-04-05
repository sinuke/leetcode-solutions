package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LemonadeChangeTest {

    @ParameterizedTest
    @MethodSource("testData")
    void lemonadeChange(int[] bills, boolean expected) {
        assertEquals(expected, new LemonadeChange().lemonadeChange(bills));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[]{5, 5, 5, 10, 20}, true),
                Arguments.of(new int[]{5, 5, 10, 10, 20}, false)
        );
    }

}

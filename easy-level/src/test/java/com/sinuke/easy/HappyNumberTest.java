package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HappyNumberTest {

    @ParameterizedTest
    @MethodSource("testData")
    void isHappy(int n, boolean expected) {
        var happy = new HappyNumber();
        assertEquals(expected, happy.isHappy(n));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(19, true),
                Arguments.of(2, false),
                Arguments.of(4, false),
                Arguments.of(1111111, true)
        );
    }

}

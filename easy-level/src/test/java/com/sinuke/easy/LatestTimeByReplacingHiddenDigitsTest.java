package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.of;

class LatestTimeByReplacingHiddenDigitsTest {

    @ParameterizedTest
    @MethodSource("testData")
    void maximumTime(String time, String expected) {
        assertEquals(expected, new LatestTimeByReplacingHiddenDigits().maximumTime(time));
    }

    private static Stream<org.junit.jupiter.params.provider.Arguments> testData() {
        return Stream.of(
                of("2?:?0", "23:50"),
                of("0?:3?", "09:39"),
                of("1?:22", "19:22")
        );
    }
}

package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.of;

class LatestTimeYouCanObtainAfterReplacingCharactersTest {

    @ParameterizedTest
    @MethodSource("testData")
    void findLatestTime(String s, String expected) {
        assertEquals(expected, new LatestTimeYouCanObtainAfterReplacingCharacters().findLatestTime(s));
    }

    private static Stream<org.junit.jupiter.params.provider.Arguments> testData() {
        return Stream.of(
                of("1?:?4", "11:54"),
                of("0?:5?", "09:59")
        );
    }
}

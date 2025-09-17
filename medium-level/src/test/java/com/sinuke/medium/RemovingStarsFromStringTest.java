package com.sinuke.medium;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RemovingStarsFromStringTest {

    @ParameterizedTest
    @MethodSource("testData")
    void removeStars(String s, String expected) {
        var solution = new RemovingStarsFromString().removeStars(s);
        assertEquals(expected, solution);
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("leet**cod*e", "lecoe"),
                Arguments.of("erase*****", "")
        );
    }

}

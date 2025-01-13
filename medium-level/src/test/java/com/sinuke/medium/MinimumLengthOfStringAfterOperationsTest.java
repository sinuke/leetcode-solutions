package com.sinuke.medium;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MinimumLengthOfStringAfterOperationsTest {

    @ParameterizedTest
    @MethodSource("testData")
    void minimumLength(String s, int expected) {
        var minimumLengthOfStringAfterOperations = new MinimumLengthOfStringAfterOperations();
        assertEquals(expected, minimumLengthOfStringAfterOperations.minimumLength(s));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("abaacbcbb", 5),
                Arguments.of("aa", 2)
        );
    }

}

package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RemoveAllAdjacentDuplicatesInStringTest {

    @ParameterizedTest
    @MethodSource("testData")
    void removeDuplicates(String str, String expected) {
        var solution = new RemoveAllAdjacentDuplicatesInString();
        assertEquals(expected, solution.removeDuplicates(str));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("abbaca", "ca"),
                Arguments.of("azxxzy", "ay")
        );
    }

}

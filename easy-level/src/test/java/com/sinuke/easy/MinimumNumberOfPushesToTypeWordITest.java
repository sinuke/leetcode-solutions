package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MinimumNumberOfPushesToTypeWordITest {

    @ParameterizedTest
    @MethodSource("testData")
    void minimumPushes(String word, int expected) {
        var solution = new MinimumNumberOfPushesToTypeWordI();
        assertEquals(expected, solution.minimumPushes(word));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("abcde", 5),
                Arguments.of("acolkxjbizfmhnrdq", 27),
                Arguments.of("amrvxnhsewkoipjyuclgtdbfq", 52),
                Arguments.of("aftwhglbypsnmueodzxcrikvqj", 56),
                Arguments.of("xycdefghij", 12)
        );
    }

}

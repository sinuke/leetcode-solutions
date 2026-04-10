package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MostCommonWordTest {

    @ParameterizedTest
    @MethodSource("testData")
    void mostCommonWord(String paragraph, String[] banned, String expected) {
        assertEquals(expected, new MostCommonWord().mostCommonWord(paragraph, banned));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("Bob hit a ball, the hit BALL flew far after it was hit.", new String[]{"hit"}, "ball"),
                Arguments.of("a.", new String[]{}, "a")
        );
    }

}

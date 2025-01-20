package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TruncateSentenceTest {

    @ParameterizedTest
    @MethodSource("testData")
    void truncateSentence(String s, int k, String expected) {
        var truncateSentence = new TruncateSentence();
        assertEquals(expected, truncateSentence.truncateSentence(s, k));
        assertEquals(expected, truncateSentence.truncateSentence2(s, k));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("Hello how are you Contestant", 4, "Hello how are you"),
                Arguments.of("What is the solution to this problem", 4, "What is the solution")
        );
    }

}

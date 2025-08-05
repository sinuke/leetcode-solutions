package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class OccurrencesAfterBigramTest {

    @ParameterizedTest
    @MethodSource("testData")
    void findOcurrences(String text, String first, String second, String[] expected) {
        var solution = new OccurrencesAfterBigram();
        assertArrayEquals(expected, solution.findOcurrences(text,first,second));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("alice is a good girl she is a good student", "a", "good", new String[] {"girl","student"}),
                Arguments.of("we will we will rock you", "we", "will", new String[] {"we","rock"})
        );
    }

}

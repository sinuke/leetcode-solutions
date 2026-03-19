package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CountVowelSubstringsOfStringTest {

    @ParameterizedTest
    @MethodSource("testData")
    void countVowelSubstrings(String word, int expected) {
        var solution = new CountVowelSubstringsOfString();
        assertEquals(expected, solution.countVowelSubstrings(word));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("aeiouu", 2),
                Arguments.of("unicornarihan", 0),
                Arguments.of("cuaieuouac", 7)
        );
    }

}

package com.sinuke;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LengthOfLastWordTest {

    @ParameterizedTest
    @MethodSource("testData")
    void lengthOfLastWord(String input, int expected) {
        var lengthOfLastWord = new LengthOfLastWord();
        assertEquals(expected, lengthOfLastWord.lengthOfLastWord(input));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("Hello World", 5),
                Arguments.of("   fly me   to   the moon  ", 4),
                Arguments.of("luffy is still joyboy", 6)
        );
    }

}

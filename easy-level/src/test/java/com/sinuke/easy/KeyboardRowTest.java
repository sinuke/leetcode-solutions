package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class KeyboardRowTest {

    @ParameterizedTest
    @MethodSource("testData")
    void findWords(String[] words, String[] expected) {
        var keyboard = new KeyboardRow();
        assertArrayEquals(expected, keyboard.findWords(words));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new String[] {"Hello","Alaska","Dad","Peace"}, new String[] {"Alaska","Dad"}),
                Arguments.of(new String[] {"omk"}, new String[] {}),
                Arguments.of(new String[] {"adsdf","sfd"}, new String[] {"adsdf","sfd"}),
                Arguments.of(new String[] {"asdfghjkl","qwertyuiop","zxcvbnm"}, new String[] {"asdfghjkl","qwertyuiop","zxcvbnm"})
        );
    }

}
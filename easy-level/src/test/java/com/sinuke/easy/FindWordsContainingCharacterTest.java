package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FindWordsContainingCharacterTest {

    @ParameterizedTest
    @MethodSource("testData")
    void findWordsContaining(String[] words, char x, List<Integer> expected) {
        var finder = new FindWordsContainingCharacter();
        assertEquals(expected, finder.findWordsContaining(words, x));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new String[] {"leet","code"}, 'e', List.of(0, 1)),
                Arguments.of(new String[] {"abc","bcd","aaaa","cbc"}, 'a', List.of(0, 2)),
                Arguments.of(new String[] {"abc","bcd","aaaa","cbc"}, 'z', List.of())
        );
    }

}

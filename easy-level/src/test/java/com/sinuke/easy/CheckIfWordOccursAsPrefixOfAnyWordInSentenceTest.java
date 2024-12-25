package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CheckIfWordOccursAsPrefixOfAnyWordInSentenceTest {

    @ParameterizedTest
    @MethodSource("testData")
    void isPrefixOfWord(String sentence, String searchWord, int expected) {
        var checkOfWord = new CheckIfWordOccursAsPrefixOfAnyWordInSentence();
        assertEquals(expected, checkOfWord.isPrefixOfWord(sentence, searchWord));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("i love eating burger", "burg", 4),
                Arguments.of("this problem is an easy problem", "pro", 2),
                Arguments.of("i am tired", "you", -1)
        );
    }

}

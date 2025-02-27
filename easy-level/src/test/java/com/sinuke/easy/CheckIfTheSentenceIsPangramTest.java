package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CheckIfTheSentenceIsPangramTest {

    @ParameterizedTest
    @MethodSource("testData")
    void checkIfPangram(String sentence, boolean expected) {
        var solution = new CheckIfTheSentenceIsPangram();
        assertEquals(expected, solution.checkIfPangram(sentence));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("thequickbrownfoxjumpsoverthelazydog", true),
                Arguments.of("leetcode", false)
        );
    }

}

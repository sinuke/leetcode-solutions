package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ReplaceAllQuestionMarksToAvoidConsecutiveRepeatingCharactersTest {

    @ParameterizedTest
    @MethodSource("testData")
    void modifyString(String s, String expected) {
        var solution = new ReplaceAllQuestionMarksToAvoidConsecutiveRepeatingCharacters();
        assertEquals(expected, solution.modifyString(s));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("?zs", "azs"),
                Arguments.of("ubv?w", "ubvaw")
        );
    }

}

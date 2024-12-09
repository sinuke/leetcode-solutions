package com.sinuke;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class LetterCombinationsOfPhoneNumberTest {

    @ParameterizedTest
    @MethodSource("testData")
    void letterCombinations(String digits, List<String> expected) {
        var letterCombinations = new LetterCombinationsOfPhoneNumber();

        var expectedArr = expected.toArray();
        var actualArr = letterCombinations.letterCombinations(digits).toArray();

        assertArrayEquals(expectedArr, actualArr);
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("23", List.of("ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf")),
                Arguments.of("67", List.of("mp", "mq", "mr", "ms", "np", "nq", "nr", "ns", "op", "oq", "or", "os")),
                Arguments.of("", Collections.emptyList()),
                Arguments.of("2", List.of("a", "b", "c")),
                Arguments.of("234", List.of("adg", "adh", "adi", "aeg", "aeh", "aei", "afg", "afh", "afi", "bdg", "bdh", "bdi", "beg", "beh", "bei", "bfg", "bfh", "bfi", "cdg", "cdh", "cdi", "ceg", "ceh", "cei", "cfg", "cfh", "cfi"))
        );
    }

}
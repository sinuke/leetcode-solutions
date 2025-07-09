package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CapitalizeTheTitleTest {

    @ParameterizedTest
    @MethodSource("testData")
    void capitalizeTitle(String title, String expected) {
        var solution = new CapitalizeTheTitle();
        assertEquals(expected, solution.capitalizeTitle(title));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("capiTalIze tHe titLe", "Capitalize The Title"),
                Arguments.of("First leTTeR of EACH Word", "First Letter of Each Word"),
                Arguments.of("i lOve leetcode", "i Love Leetcode")
        );
    }

}

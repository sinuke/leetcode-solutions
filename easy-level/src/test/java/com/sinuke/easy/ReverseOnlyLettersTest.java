package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ReverseOnlyLettersTest {

    @ParameterizedTest
    @MethodSource("testData")
    void reverseOnlyLetters(String s, String expected) {
        var solution = new ReverseOnlyLetters();
        assertEquals(expected, solution.reverseOnlyLetters(s));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("ab-cd", "dc-ba"),
                Arguments.of("a-bC-dEf-ghIj", "j-Ih-gfE-dCba"),
                Arguments.of("Test1ng-Leet=code-Q!", "Qedo1ct-eeLg=ntse-T!")
        );
    }

}

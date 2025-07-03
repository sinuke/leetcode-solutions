package com.sinuke.medium;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class KthSymbolInGrammarTest {

    @ParameterizedTest
    @MethodSource("testData")
    void kthGrammar(int n, int k, int expected) {
        var solution = new  KthSymbolInGrammar();
        assertEquals(expected, solution.kthGrammar(n, k));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(1, 1, 0),
                Arguments.of(2, 1, 0),
                Arguments.of(2, 2, 1),
                Arguments.of(30, 434991989, 0)
        );
    }

}

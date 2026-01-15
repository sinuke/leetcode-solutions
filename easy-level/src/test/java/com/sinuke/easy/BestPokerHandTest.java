package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BestPokerHandTest {

    @ParameterizedTest
    @MethodSource("testData")
    void bestHand(int[] ranks, char[] suits, String expected) {
        var solution = new BestPokerHand();
        assertEquals(expected, solution.bestHand(ranks, suits));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[] {13,2,3,1,9}, new char[] {'a','a','a','a','a'}, "Flush"),
                Arguments.of(new int[] {4,4,2,4,4}, new char[] {'d','a','a','b','c'}, "Three of a Kind"),
                Arguments.of(new int[] {10,10,2,12,9}, new char[] {'a','b','c','a','d'}, "Pair")
        );
    }

}

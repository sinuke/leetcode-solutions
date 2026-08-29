package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class XOfAKindInADeckOfCardsTest {

    @ParameterizedTest
    @MethodSource("testData")
    void hasGroupsSizeX(int[] deck, boolean expected) {
        var xOfAKindInADeckOfCards = new XOfAKindInADeckOfCards();
        assertEquals(expected, xOfAKindInADeckOfCards.hasGroupsSizeX(deck));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[] {1, 2, 3, 4, 4, 3, 2, 1}, true),
                Arguments.of(new int[] {1, 1, 1, 2, 2, 2, 3, 3}, false)
        );
    }

}

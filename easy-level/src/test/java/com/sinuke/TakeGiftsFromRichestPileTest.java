package com.sinuke;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TakeGiftsFromRichestPileTest {

    @ParameterizedTest
    @MethodSource("testData")
    void pickGifts(int[] gifts, int k, int expected) {
        var takeGifts = new TakeGiftsFromRichestPile();
        assertEquals(expected, takeGifts.pickGifts(gifts, k));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[] {25, 64, 9, 4, 100}, 4, 29),
                Arguments.of(new int[] {1, 1, 1, 1}, 4, 4)
        );
    }

}
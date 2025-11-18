package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class OneBitAndTwoBitCharactersTest {

    @ParameterizedTest
    @MethodSource("testData")
    void isOneBitCharacter(int[] bits, boolean expected) {
        var solution = new OneBitAndTwoBitCharacters();
        assertEquals(expected, solution.isOneBitCharacter(bits));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[] {1,0,0}, true),
                Arguments.of(new int[] {1,1,1,0}, false)
        );
    }

}

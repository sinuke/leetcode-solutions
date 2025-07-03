package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FindTheKthCharacterInStringGameITest {

    @ParameterizedTest
    @MethodSource("testData")
    void kthCharacter(int k, char expected) {
        var solution = new FindTheKthCharacterInStringGameI();
        assertEquals(expected, solution.kthCharacter(k));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(5, 'b'),
                Arguments.of(10, 'c')
        );
    }

}

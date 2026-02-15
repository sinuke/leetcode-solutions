package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RearrangeCharactersToMakeTargetStringTest {

    @ParameterizedTest
    @MethodSource("testData")
    void rearrangeCharacters(String s, String target, int expected) {
        var solution = new RearrangeCharactersToMakeTargetString();
        assertEquals(expected, solution.rearrangeCharacters(s, target));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("ilovecodingonleetcode", "code", 2),
                Arguments.of("abcba", "abc", 1),
                Arguments.of("abbaccaddaeea", "aaaaa", 1)
        );
    }

}

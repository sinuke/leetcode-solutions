package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FindCommonCharactersTest {

    @ParameterizedTest
    @MethodSource("testData")
    void commonChars(String[] words, List<String> expected) {
        var solution =  new FindCommonCharacters();
        assertEquals(expected, solution.commonChars(words));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new String[] {"bella","label","roller"}, List.of("e","l","l")),
                Arguments.of(new String[] {"cool","lock","cook"}, List.of("c","o"))
        );
    }

}

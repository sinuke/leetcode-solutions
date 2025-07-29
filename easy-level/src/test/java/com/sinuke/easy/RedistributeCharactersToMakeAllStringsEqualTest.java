package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RedistributeCharactersToMakeAllStringsEqualTest {

    @ParameterizedTest
    @MethodSource("testData")
    void makeEqual(String[] words, boolean expected) {
        var solution = new RedistributeCharactersToMakeAllStringsEqual();
        assertEquals(expected, solution.makeEqual(words));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new String[] {"abc","aabc","bc"}, true),
                Arguments.of(new String[] {"ab","a"}, false)
        );
    }

}

package com.sinuke;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class IsomorphicStringsTest {

    @ParameterizedTest
    @MethodSource("testData")
    void isIsomorphic(String s, String t, boolean expected) {
        var isomorphicStrings = new IsomorphicStrings();
        
        assertEquals(expected, isomorphicStrings.isIsomorphic(s, t));
    }
    
    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("egg", "add", true),
                Arguments.of("foo", "bar", false),
                Arguments.of("paper", "title", true),
                Arguments.of("badc", "baba", false),
                Arguments.of("bbbaaaba", "aaabbbba", false),
                Arguments.of("aa", "ab", false)
        );
    }
    
}

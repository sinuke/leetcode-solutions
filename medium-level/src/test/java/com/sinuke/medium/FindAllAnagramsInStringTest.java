package com.sinuke.medium;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FindAllAnagramsInStringTest {

    @ParameterizedTest
    @MethodSource("testData")
    void findAnagrams(String s, String p, List<Integer> expected) {
        var solution = new FindAllAnagramsInString();
        assertEquals(expected, solution.findAnagrams(s, p));
        assertEquals(expected, solution.findAnagrams2(s, p));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("cbaebabacd", "abc", List.of(0, 6)),
                Arguments.of("abab", "ab", List.of(0,1,2))
        );
    }

}

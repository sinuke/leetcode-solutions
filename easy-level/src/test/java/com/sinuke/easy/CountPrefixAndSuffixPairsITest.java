package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CountPrefixAndSuffixPairsITest {

    @ParameterizedTest
    @MethodSource("testData")
    void countPrefixSuffixPairs(String[] words, int expected) {
        var counter = new CountPrefixAndSuffixPairsI();
        assertEquals(expected, counter.countPrefixSuffixPairs(words));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new String[] {"a","aba","ababa","aa"}, 4),
                Arguments.of(new String[] {"pa","papa","ma","mama"}, 2),
                Arguments.of(new String[] {"abab","ab"}, 0)
        );
    }

}

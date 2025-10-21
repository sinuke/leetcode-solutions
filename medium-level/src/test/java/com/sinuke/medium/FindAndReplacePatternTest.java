package com.sinuke.medium;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FindAndReplacePatternTest {

    @ParameterizedTest
    @MethodSource("testData")
    void findAndReplacePattern(String[] words, String pattern, List<String> expected) {
        var solution = new FindAndReplacePattern();
        assertEquals(expected, solution.findAndReplacePattern(words, pattern));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new String[] {"abc","deq","mee","aqq","dkd","ccc"}, "abb", List.of("mee","aqq")),
                Arguments.of(new String[] {"a","b","c"}, "a", List.of("a","b","c"))
        );
    }

}

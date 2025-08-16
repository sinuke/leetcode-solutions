package com.sinuke.medium;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TopKFrequentWordsTest {

    @ParameterizedTest
    @MethodSource("testData")
    void topKFrequent(String[] words, int k, List<String> expected) {
        var solution = new TopKFrequentWords();
        assertEquals(expected, solution.topKFrequent(words, k));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new String[]{"i","love","leetcode","i","love","coding"}, 2, List.of("i","love")),
                Arguments.of(new String[]{"the","day","is","sunny","the","the","the","sunny","is","is"}, 4, List.of("the","is","sunny","day"))
        );
    }

}
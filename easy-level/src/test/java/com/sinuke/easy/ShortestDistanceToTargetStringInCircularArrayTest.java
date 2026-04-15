package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ShortestDistanceToTargetStringInCircularArrayTest {

    @ParameterizedTest
    @MethodSource("testData")
    void closestTarget(String[] words, String target, int startIndex, int expected) {
        assertEquals(expected, new ShortestDistanceToTargetStringInCircularArray().closestTarget(words, target, startIndex));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new String[]{"hello", "i", "am", "leetcode", "hello"}, "hello", 1, 1),
                Arguments.of(new String[]{"a", "b", "leetcode"}, "leetcode", 0, 1),
                Arguments.of(new String[]{"i", "eat", "leetcode"}, "ate", 0, -1)
        );
    }

}

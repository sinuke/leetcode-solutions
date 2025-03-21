package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class KthDistinctStringInArrayTest {

    @ParameterizedTest
    @MethodSource("testData")
    void kthDistinct(String[] arr, int k, String expected) {
        var solution = new KthDistinctStringInArray();
        assertEquals(expected, solution.kthDistinct(arr, k));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new String[] {"d","b","c","b","c","a"}, 2, "a"),
                Arguments.of(new String[] {"aaa","aa","a"}, 1, "aaa"),
                Arguments.of(new String[] {"a","b","a"}, 3, ""),
                Arguments.of(new String[] {"b","a","c","a"}, 2, "c")
        );
    }

}

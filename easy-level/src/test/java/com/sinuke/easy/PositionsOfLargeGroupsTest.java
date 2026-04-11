package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PositionsOfLargeGroupsTest {

    @ParameterizedTest
    @MethodSource("testData")
    void largeGroupPositions(String s, List<List<Integer>> expected) {
        assertEquals(expected, new PositionsOfLargeGroups().largeGroupPositions(s));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("abbxxxxzzy", List.of(List.of(3, 6))),
                Arguments.of("abc", List.of()),
                Arguments.of("abcdddeeeeaabbbcd", List.of(List.of(3, 5), List.of(6, 9), List.of(12, 14)))
        );
    }

}

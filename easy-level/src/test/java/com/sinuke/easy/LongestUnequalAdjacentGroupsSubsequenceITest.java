package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LongestUnequalAdjacentGroupsSubsequenceITest {

    @ParameterizedTest
    @MethodSource("testData")
    void getLongestSubsequence(String[] words, int[] groups, List<String> expected) {
        var solution = new LongestUnequalAdjacentGroupsSubsequenceI();
        assertEquals(expected, solution.getLongestSubsequence(words, groups));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new String[]{"e", "a", "b"}, new int[]{0, 0, 1}, List.of("e", "b")),
                Arguments.of(new String[]{"a", "b", "c", "d"}, new int[]{1, 0, 1, 1}, List.of("a", "b", "c"))
        );
    }

}

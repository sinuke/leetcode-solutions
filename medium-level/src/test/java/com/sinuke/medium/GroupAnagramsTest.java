package com.sinuke.medium;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GroupAnagramsTest {

    @ParameterizedTest
    @MethodSource("testData")
    void groupAnagrams(String[] strs, List<List<String>> expected) {
        var solution = new GroupAnagrams();
        assertEquals(expected.size(), solution.groupAnagrams(strs).size());
        assertEquals(expected.size(), solution.groupAnagrams2(strs).size());
        assertEquals(expected.size(), solution.groupAnagrams3(strs).size());
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new String[] {"eat","tea","tan","ate","nat","bat"}, List.of(List.of("bat"), List.of("nat","tan"), List.of("ate","eat","tea"))),
                Arguments.of(new String[] {""}, List.of(List.of(""))),
                Arguments.of(new String[] {"a"}, List.of(List.of("a")))
        );
    }

}
